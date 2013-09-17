package client.net.sf.saxon.ce.value;

import client.net.sf.saxon.ce.expr.XPathContext;
import client.net.sf.saxon.ce.lib.StringCollator;
import client.net.sf.saxon.ce.om.Item;
import client.net.sf.saxon.ce.om.NodeInfo;
import client.net.sf.saxon.ce.trans.NoDynamicContextException;
import client.net.sf.saxon.ce.trans.XPathException;
import client.net.sf.saxon.ce.tree.iter.SingletonIterator;
import client.net.sf.saxon.ce.tree.iter.UnfailingIterator;
import client.net.sf.saxon.ce.type.AtomicType;
import client.net.sf.saxon.ce.type.ConversionResult;
import client.net.sf.saxon.ce.type.Type;


/**
 * The AtomicValue class corresponds to the concept of an atomic value in the
 * XPath 2.0 data model. Atomic values belong to one of the 19 primitive types
 * defined in XML Schema; or they are of type xs:untypedAtomic; or they are
 * "external objects", representing a Saxon extension to the XPath 2.0 type system.
 * <p/>
 * The AtomicValue class contains some methods that are suitable for applications
 * to use, and many others that are designed for internal use by Saxon itself.
 * These have not been fully classified. At present, therefore, none of the methods on this
 * class should be considered to be part of the public Saxon API.
 * <p/>
 *
 * @author Michael H. Kay
 */

public abstract class AtomicValue implements Item, ConversionResult {

    /**
     * Get an object value that implements the XPath equality and ordering comparison semantics for this value.
     * If the ordered parameter is set to true, the result will be a Comparable and will support a compareTo()
     * method with the semantics of the XPath lt/gt operator, provided that the other operand is also obtained
     * using the getXPathComparable() method. In all cases the result will support equals() and hashCode() methods
     * that support the semantics of the XPath eq operator, again provided that the other operand is also obtained
     * using the getXPathComparable() method. A context argument is supplied for use in cases where the comparison
     * semantics are context-sensitive, for example where they depend on the implicit timezone or the default
     * collation.
     *
     *
     * @param ordered true if an ordered comparison is required. In this case the result is null if the
     * type is unordered; in other cases the returned value will be a Comparable.
     * @param collator the collation to be used when comparing strings
     * @param implicitTimezone the implicit timezone, needed when comparing date/time values
     * @return an Object whose equals() and hashCode() methods implement the XPath comparison semantics
     *         with respect to this atomic value. If ordered is specified, the result will either be null if
     *         no ordering is defined, or will be a Comparable
     * @throws NoDynamicContextException if the comparison depends on dynamic context information that
     * is not available, for example implicit timezone
     */

    public abstract Object getXPathComparable(boolean ordered, StringCollator collator, int implicitTimezone);

    /**
     * The equals() methods on atomic values is defined to follow the semantics of eq when applied
     * to two atomic values. When the other operand is not an atomic value, the result is undefined
     * (may be false, may be an exception). When the other operand is an atomic value that cannot be
     * compared with this one, the method must throw a ClassCastException.
     *
     * <p>The hashCode() method is consistent with equals().</p>
     * @param o the other value
     * @return true if the other operand is an atomic value and the two values are equal as defined
     * by the XPath eq operator
     */

    public abstract boolean equals(Object o);

    /**
     * Process the instruction, without returning any tail calls
     *
     * @param context The dynamic context, giving access to the current node,
     *                the current variables, etc.
     */

    public void process(XPathContext context) throws XPathException {
        context.getReceiver().append(this, NodeInfo.ALL_NAMESPACES);
    }

    /**
     * Get the n'th item in the sequence (starting from 0). This is defined for all
     * Values, but its real benefits come for a sequence Value stored extensionally
     * (or for a MemoClosure, once all the values have been read)
     *
     * @param n position of the required item, counting from zero.
     * @return the n'th item in the sequence, where the first item in the sequence is
     *         numbered zero. If n is negative or >= the length of the sequence, returns null.
     */

    public final Item itemAt(int n) {
        return (n == 0 ? this : null);
    }

    /**
     * Determine the primitive type of the value. This delivers the same answer as
     * getItemType().getPrimitiveItemType(). The primitive types are
     * the 19 primitive types of XML Schema, plus xs:integer, xs:dayTimeDuration and xs:yearMonthDuration,
     * and xs:untypedAtomic. For external objects, the result is xs:anyAtomicType.
     *
     * @return the primitive type
     */

    public abstract AtomicType getItemType();

    /**
     * Convert a value to either (a) another primitive type, or (b) another built-in type derived
     * from the current primitive type, with control over how validation is
     * handled.
     *
     *
     * @param requiredType the required atomic type. This must either be a primitive type, or a built-in
     *                     type derived from the same primitive type as this atomic value.
     * @return the result of the conversion, if successful. If unsuccessful, the value returned
     *         will be a ValidationFailure. The caller must check for this condition. No exception is thrown, instead
     *         the exception information will be encapsulated within the ValidationFailure.
     */
    public abstract ConversionResult convert(AtomicType requiredType);

    /**
     * Test whether the value is the special value NaN
     * @return true if the value is float NaN or double NaN or precisionDecimal NaN; otherwise false
     */

    public boolean isNaN() {
        return false;
    }

    /**
     * Get the length of the sequence
     *
     * @return always 1 for an atomic value
     */

    public final int getLength() {
        return 1;
    }

    /**
     * Iterate over the (single) item in the sequence
     *
     * @return a SequenceIterator that iterates over the single item in this
     *         value
     */

    public final UnfailingIterator iterate() {
        return SingletonIterator.makeIterator(this);
    }

    /**
     * Convert the value to a string, using the serialization rules.
     * For atomic values this is the same as a cast; for sequence values
     * it gives a space-separated list. This method is refined for AtomicValues
     * so that it never throws an Exception.
     */

    public final String getStringValue() {
        return getPrimitiveStringValue().toString();
    }

    /**
     * Convert the value to a string, using the serialization rules for the primitive type.
     * @return the value converted to a string according to the rules for the primitive type
     */

    protected abstract CharSequence getPrimitiveStringValue();


    /**
     * Get the typed value of this item
     *
     * @return the typed value of the expression (which is this value)
     */

    public final AtomicValue getTypedValue() {
        return this;
    }

    /**
     * Get the effective boolean value of the value
     *
     * @return true, unless the value is boolean false, numeric zero, or
     *         zero-length string
     */
    public boolean effectiveBooleanValue() throws XPathException {
        XPathException err = new XPathException("Effective boolean value is not defined for an atomic value of type " +
                Type.displayTypeName(this), "FORG0006");
        err.setIsTypeError(true);
        throw err;
        // unless otherwise specified in a subclass
    }

    /**
     * Method to extract components of a value. Implemented by some subclasses,
     * but defined at this level for convenience
     *
     * @param component identifies the required component, as a constant defined in class
     *                  {@link client.net.sf.saxon.ce.functions.Component}, for example {@link client.net.sf.saxon.ce.functions.Component#HOURS}
     * @return the value of the requested component of this value
     */

    public AtomicValue getComponent(int component) throws XPathException {
        throw new UnsupportedOperationException("Data type does not support component extraction");
    }


    /**
     * Calling this method on a ConversionResult returns the AtomicValue that results
     * from the conversion if the conversion was successful, and throws a ValidationException
     * explaining the conversion error otherwise.
     * <p/>
     * <p>Use this method if you are calling a conversion method that returns a ConversionResult,
     * and if you want to throw an exception if the conversion fails.</p>
     *
     * @return the atomic value that results from the conversion if the conversion was successful
     */

    public AtomicValue asAtomic() {
        return this;
    }


    /**
     * Get string value. In general toString() for an atomic value displays the value as it would be
     * written in XPath: that is, as a literal if available, or as a call on a constructor function
     * otherwise.
     */

    public String toString() {
        return getItemType().toString() + " (\"" + getStringValue() + "\")";
    }

}

// This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
// If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
// This Source Code Form is “Incompatible With Secondary Licenses”, as defined by the Mozilla Public License, v. 2.0.

