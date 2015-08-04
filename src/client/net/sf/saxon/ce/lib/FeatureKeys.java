package client.net.sf.saxon.ce.lib;

// GENERATED FROM FeatureKeys.xml - DO NOT EDIT THIS FILE


/**
  * FeatureKeys defines a set of constants, representing the names of Saxon configuration
  * options
  *
  * @author Michael H. Kay
  */

public abstract class FeatureKeys {


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>ALLOW_EXTERNAL_FUNCTIONS determines whether calls to reflexive external functions are
    *  allowed. More specifically, if set to <b>false</b> it disallows all of the
    *  following:</p>
    *
    *  <ul>
    *  <li>Calls to reflexive Java extension functions</li>
    *  <li>Use of the XSLT system-property() function to access Java system properties</li>
    *  <li>Use of a relative URI in the <code>xsl:result-document</code> instruction</li>
    *  <li>Calls to XSLT extension instructions</li>
    *  </ul>
    *
    *  <p>The default value is <b>true</b>. The setting <b>false</b> is recommended in an
    *  environment where untrusted stylesheets may be executed.</p>
    *
    *  <p>This option does not disable use of the <code>doc()</code> function or similar
    *  functions to access the filestore of the machine where the transformation or query
    *  is running. That should be done using a user-supplied <code>URIResolver</code></p>
    *
    *  <p>Note that integrated extension functions are trusted; calls to such functions are
    *  allowed even if this configuration option is false. In cases where an integrated
    *  extension function is used to load and execute untrusted code, it should check this
    *  configuration option before doing so.</p>
    *
    * <p><i>Corresponding attribute in configuration file: global/@allowExternalFunctions</i></p>
    * <p><i>Corresponding option on command line (Transform, Query): -ext</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setAllowExternalFunctions
    * @see client.net.sf.saxon.ce.Configuration#isAllowExternalFunctions
    **/

    public final static String ALLOW_EXTERNAL_FUNCTIONS =
        "http://saxon.sf.net/feature/allow-external-functions";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

  
// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: instance of class client.net.sf.saxon.ce.Configuration</p>
    *
    *  <p>This attribute cannot be set on the {@link client.net.sf.saxon.ce.Configuration} itself,
    *  but it can be set on various JAXP factory objects such as a TransformerFactory or
    *  DocumentBuilderFactory, to ensure that several such factories use the same
    *  Configuration. Note that other configuration options are held in the Configuration
    *  object, so setting this attribute will cancel all others that have been set. Also,
    *  if two factories share the same configuration, then setting an attribute on one
    *  affects all the others.</p>
    *
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    **/

    public final static String CONFIGURATION =
        "http://saxon.sf.net/feature/configuration";


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: filename</p>
    * <p>Defines a configuration file to be applied to the configuration. This attribute cannot
    *  be set on the {@link client.net.sf.saxon.ce.Configuration} itself, but it can be set on
    *  various JAXP factory objects such as a <code>TransformerFactory</code> or
    *  <code>DocumentBuilderFactory</code>. It is particularly useful when running
    *  transformations via the Ant xslt task, where it can be set as follows to define all
    *  configuration settings: </p><p>
    *  <factory name="client.net.sf.saxon.ce.TransformerFactoryImpl">
    *  <attribute name="http://saxon.sf.net/feature/configuration-file"
    *  value="c:/saxon/config.xml"/>
    *  </factory>
    *  </p>
    *
    * <p><i>Corresponding option on command line (Transform, Query, Validate): -config:filename</i></p>
    * <p><i>Applies to Saxon editions: PE EE</i></p>
    **/

    public final static String CONFIGURATION_FILE =
        "http://saxon.sf.net/feature/configuration-file";


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: Absolute URI (collation URI)</p>
    *
    *  <p>This option determines the collation that is used for comparing strings when no
    *  explicit collation is requested. It is not necessary for this collation to exist (or
    *  to have been registered) when setting this option; it only needs to exist by the
    *  time it is used.</p>
    *  <p>In XSLT it is possible to override this setting using the
    *  <code>[xsl:]default-collation</code> attribute on any stylesheet element.</p>
    *  <p>If no value is specified, the Unicode codepoint collation is used.</p>
    *
    * <p><i>Corresponding attribute in configuration file: global/@defaultCollation</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>

    **/

    public final static String DEFAULT_COLLATION =
        "http://saxon.sf.net/feature/defaultCollation";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>If true, the XML parser is requested to perform validation of source documents
    *  against their DTD. Default is false.</p>
    *  <p>This option establishes a default for use whenever source documents (not stylesheets
    *  or schema documents) are parsed. The option can be overridden for individual
    *  documents by setting the {@link client.net.sf.saxon.ce.lib.ParseOptions} for that
    *  individual document, for example from a <code>URIResolver</code>.</p>
    *
    * <p><i>Corresponding option on command line (Transform, Query): -dtd:(on|off|recover)</i></p>
    * <p><i>Corresponding attribute in configuration file: global/@dtdValidation</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setValidation
    * @see client.net.sf.saxon.ce.Configuration#isValidation
    **/

    public final static String DTD_VALIDATION =
        "http://saxon.sf.net/feature/validation";


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>This option determines whether DTD validation failures should be treated as
    *  recoverable. If the option is set, a validation failure is reported as a warning
    *  rather than an error. The default is false.</p>
    *  <p>This option establishes a default for use whenever source documents (not stylesheets
    *  or schema documents) are parsed. The option can be overridden for individual
    *  documents by setting the {@link client.net.sf.saxon.ce.lib.ParseOptions} for that
    *  individual document, for example from a <code>URIResolver</code>.</p>
    *
    * <p><i>Corresponding option on command line (Transform, Query, Validate): -dtd:(on|off|recover)</i></p>
    * <p><i>Corresponding attribute in configuration file: global/@dtdValidationRecoverable</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    **/

    public final static String DTD_VALIDATION_RECOVERABLE =
        "http://saxon.sf.net/feature/dtd-validation-recoverable";


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: Name of class implementing org.xml.sax.ErrorListener</p>
    *
    *  <p>ERROR_LISTENER_CLASS is the name of the class used to implement the JAXP
    *  <code>ErrorListener</code>. This is used both at compile time and at run-time.
    *  Currently if this option is specified, the class is instantiated, and the same
    *  instance is used for all processes running under this configuration. This may change
    *  in future so that a new instance is created for each compilation or evaluation.</p>
    *  <p>Finer control can be obtained by setting the <code>ErrorListener</code> for a
    *  specific XSLT or XQuery compilation or evaluation.</p>
    *
    * <p><i>Corresponding attribute in configuration file: global/@errorListener</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setErrorListener
    * @see client.net.sf.saxon.ce.Configuration#getErrorListener
    **/

    public final static String ERROR_LISTENER_CLASS =
        "http://saxon.sf.net/feature/errorListenerClass";


// AUTO-GENERATED CODE: DO NOT EDIT

// AUTO-GENERATED CODE: DO NOT EDIT



// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>Default is false. If true, line and column number information is retained for all
    *  source documents. </p>
    *  <p>Note that the information is only as good as the XML parser supplies. SAX parsers
    *  generally report the position of an element node using the line and column number of
    *  the ">" character that forms the last character of the start tag.</p>
    *
    * <p><i>Corresponding option on command line (Transform, Query, Validate): -l:(on|off)</i></p>
    * <p><i>Corresponding attribute in configuration file: global/@lineNumbering</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    **/

    public final static String LINE_NUMBERING =
        "http://saxon.sf.net/feature/linenumbering";


// AUTO-GENERATED CODE: DO NOT EDIT



// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: Instance of client.net.sf.saxon.ce.om.NamePool</p>
    *
    *  <p>Indicates that the supplied <code>NamePool</code> should be used as the target
    *  (run-time) NamePool by all stylesheets compiled (using <code>newTemplates()</code>)
    *  after this call on <code>setAttribute</code>. Normally a single system-allocated
    *  <code>NamePool</code> is used for all stylesheets compiled while the Java VM
    *  remains loaded; this attribute allows user control over the allocation of name
    *  pools. Note that source trees used as input to a transformation must be built using
    *  the same <code>NamePool</code> that is used when the stylesheet is compiled: this
    *  will happen automatically if the input to a transformation is supplied as a
    *  <code>SAXSource</code> or <code>StreamSource</code> but it is under user control
    *  if you build the source tree yourself.</p>
    *
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setNamePool
    * @see client.net.sf.saxon.ce.Configuration#getNamePool
    **/

    public final static String NAME_POOL =
        "http://saxon.sf.net/feature/namePool";


// AUTO-GENERATED CODE: DO NOT EDIT



// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: integer (0..10)</p>
    *
    *  <p>A string whose value is an integer in the range 0 (no optimization) to 10 (full
    *  optimization); currently all values other than 0 result in full optimization but
    *  this is likely to change in future. The default is full optimization; this feature
    *  allows optimization to be suppressed in cases where reducing compile time is
    *  important, or where optimization gets in the way of debugging, or causes extension
    *  functions with side-effects to behave unpredictably. (Note however, that even with
    *  no optimization, lazy evaluation may still cause the evaluation order to be not as
    *  expected.) </p>
    *
    * <p><i>Corresponding option on command line (Transform, Query): -opt:integer</i></p>
    * <p><i>Corresponding attribute in configuration file: global/@optimizationLevel</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.expr.Optimizer#setOptimizationLevel
    * @see client.net.sf.saxon.ce.expr.Optimizer#getOptimizationLevel
    **/

    public final static String OPTIMIZATION_LEVEL =
        "http://saxon.sf.net/feature/optimizationLevel";


// AUTO-GENERATED CODE: DO NOT EDIT



// AUTO-GENERATED CODE: DO NOT EDIT

// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

 
// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: integer (0..2)</p>
    *
    *  <p>An Integer, one of {@link client.net.sf.saxon.ce.Configuration#RECOVER_SILENTLY},
    *  {@link client.net.sf.saxon.ce.Configuration#RECOVER_WITH_WARNINGS}, or
    *  {@link client.net.sf.saxon.ce.Configuration#DO_NOT_RECOVER}. Indicates the policy for
    *  handling dynamic errors that the XSLT specification defines as recoverable. 0 means
    *  recover silently; 1 means recover after signalling a warning to the
    *  <code>ErrorListener</code>; 2 means treat the error as fatal. An example of a
    *  recoverable error is when two template rules match the same node.</p>
    *
    * <p><i>Corresponding option on command line (Transform): -warnings:(silent|recover|fatal)</i></p>
    * <p><i>Corresponding attribute in configuration file: xslt/@recoveryPolicy</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setRecoveryPolicy
    * @see client.net.sf.saxon.ce.Configuration#getRecoveryPolicy
    **/

    public final static String RECOVERY_POLICY =
        "http://saxon.sf.net/feature/recoveryPolicy";


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: string ("recoverSilently", "recoverWithWarnings", or "doNotRecover")</p>
    *
    *  <p>Indicates the policy for handling dynamic errors that the XSLT specification defines
    *  as recoverable. "recoverSilently" means recover silently; "recoverWithWarnings"
    *  means recover after signalling a warning to the <code>ErrorListener</code>;
    *  "doNotRecover" means treat the error as fatal. An example of a recoverable error is
    *  when two template rules match the same node. </p>
    *
    * <p><i>Corresponding option on command line (Transform): -warnings:(silent|recover|fatal)</i></p>
    * <p><i>Corresponding attribute in configuration file: xslt/@recoveryPolicy</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setRecoveryPolicy
    * @see client.net.sf.saxon.ce.Configuration#getRecoveryPolicy
    **/

    public final static String RECOVERY_POLICY_NAME =
        "http://saxon.sf.net/feature/recoveryPolicyName";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: string ("all", "none", or "ignorable")</p>
    *
    *  <p>Indicates whether all whitespace, no whitespace, or whitespace in elements defined in
    *  a DTD or schema as having element-only content should be stripped from source
    *  documents. The default is "ignorable". This whitespace stripping is additional to
    *  any stripping done as a result of the <code>xsl:strip-space</code> declaration in an
    *  XSLT stylesheet.</p>
    *
    * <p><i>Corresponding attribute in configuration file: global/@stripWhitespace</i></p>
    * <p><i>Corresponding option on command line (Transform, Query, Validate): -strip:(all|none|ignorable)</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setStripsWhiteSpace
    * @see client.net.sf.saxon.ce.Configuration#getStripsWhiteSpace
    **/

    public final static String STRIP_WHITESPACE =
        "http://saxon.sf.net/feature/strip-whitespace";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>This is set to true to cause basic timing and tracing information is to be output to
    *  the standard error output stream. The name of the feature is poorly chosen, since
    *  much of the information that is output has nothing to do with timing, for example
    *  the names of output files for <code>xsl:result-document</code> are traced.</p>
    *
    * <p><i>Corresponding attribute in configuration file: global/@timing</i></p>
    * <p><i>Corresponding option on command line (Transform, Query, Validate): -t</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setTiming
    * @see client.net.sf.saxon.ce.Configuration#isTiming
    **/

    public final static String TIMING =
        "http://saxon.sf.net/feature/timing";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>This option determines whether a <code>TransformerHandler</code> created with this
    *  <code>TransformerFactory</code> or <code>Configuration</code> recognizes the
    *  JAXP-defined processing instructions <code>Result.PI_DISABLE_OUTPUT_ESCAPING</code>
    *  and <code>Result.PI_ENABLE_OUTPUT_ESCAPING</code> in the input stream as
    *  instructions to disable or to re-enable output escaping. The default value is
    *  <b>false</b>.</p>
    *
    * <p><i>Corresponding attribute in configuration file: global/@usePiDisableOutputEscaping</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    **/

    public final static String USE_PI_DISABLE_OUTPUT_ESCAPING =
        "http://saxon.sf.net/feature/use-pi-disable-output-escaping";


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>This option is relevant only when the TinyTree is used; it determines whether (for a
    *  validated document) a cache will be maintained containing the typed values of nodes.
    *  Typed values are held in the cache only for elements and attributes whose type is
    *  other than string, untypedAtomic, or anyURI. The default value is true. Setting this
    *  value to false can reduce memory requirements at the cost of requiring recomputation
    *  of typed values on each access.</p>
    *
    * <p><i>Corresponding attribute in configuration file: global/@useTypedValueCache</i></p>
    * <p><i>Applies to Saxon editions: EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#useTypedValueCache
    **/

    public final static String USE_TYPED_VALUE_CACHE =
        "http://saxon.sf.net/feature/use-typed-value-cache";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: boolean</p>
    *
    *  <p>Indicates whether a warning message should be notified (to the
    *  <code>ErrorListener</code>) if running Saxon against an XSLT stylesheet that
    *  specifies <code>version="1.0"</code>. The warning that an XSLT 1.0 stylesheet is
    *  being processed using an XSLT 2.0 processor is output by default (because the W3C
    *  specification requires it), but it may be suppressed using this option.</p>
    *
    * <p><i>Corresponding attribute in configuration file: xslt/@versionWarning</i></p>
    * <p><i>Corresponding option on command line (Transform): -versmsg:(on|off)</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    * @see client.net.sf.saxon.ce.Configuration#setVersionWarning
    * @see client.net.sf.saxon.ce.Configuration#isVersionWarning
    **/

    public final static String VERSION_WARNING =
        "http://saxon.sf.net/feature/version-warning";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: a QName in Clark notation</p>
    *
    *  <p>This property indicates the name of a mode within a stylesheet in which execution
    *  (using template rules) should begin</p>
    *  <p>This option can be set for a particular XSLT transformation. When the option is set at
    *  the <code>Configuration</code> (or on a <code>TransformerFactory</code>), it acts as a default.</p>
    *
    * <p><i>Corresponding option on command line (Transform): -im:mode-name</i></p>
    * <p><i>Corresponding attribute in configuration file: xslt/@initialMode</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    **/

    public final static String XSLT_INITIAL_MODE =
        "http://saxon.sf.net/feature/initialMode";


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: a QName in Clark notation</p>
    *
    *  <p>This property indicates the name of a named template within a stylesheet where
    *  execution should begin</p>
    *  <p>This option can be set for a particular XSLT transformation. When the option is set at
    *  the <code>Configuration</code> level (or on a <code>TransformerFactory</code>), it acts as a default.</p>
    *
    * <p><i>Corresponding option on command line (Transform): -it:template-name</i></p>
    * <p><i>Corresponding attribute in configuration file: xslt/@initialTemplate</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
    **/

    public final static String XSLT_INITIAL_TEMPLATE =
        "http://saxon.sf.net/feature/initialTemplate";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT

    /**
    *
    * <p>Type of value: the name of a class that implements
            javax.xml.transform.ErrorListener</p>
    *
    *  <p>The specified class is instantiated to create an <code>ErrorListener</code>,
    *  and all reports of static errors in a styleExecution time: 620mssheet will go to this
    *  <code>ErrorListener</code>.</p>
    *  <p>This option can be set for a particular XSLT compilation. When the option is set at
    *  the <code>Configuration</code> level (or on a <code>TransformerFactory</code>), it acts as a default.</p>
    *  <p>In the absence of this property, the global <code>ErrorListener</code>
    *  is used.</p>
    *
    * <p><i>Corresponding attribute in configuration file: xslt/@staticErrorListener</i></p>
    * <p><i>Applies to Saxon editions: HE PE EE</i></p>
       **/

    public final static String XSLT_STATIC_ERROR_LISTENER_CLASS =
        "http://saxon.sf.net/feature/stylesheetErrorListener";


// AUTO-GENERATED CODE: DO NOT EDIT


// AUTO-GENERATED CODE: DO NOT EDIT


}