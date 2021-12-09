/* $$ This file has been instrumented by Clover 4.3.1#20180921211537623 $$ */package com.mycompany.app;

/**
 * @author MM Formations
 * Hello world! classe pour d\u00e9mo Maven/Jenkins
 */
public class App
{public static class __CLR4_3_100kwtmwvaf{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_3_1();if(20180921211537623L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.3.1#20180921211537623,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0044\u003a\u005c\u005c\u0064\u0061\u0074\u0061\u005c\u005c\u0046\u006f\u0072\u006d\u0061\u0074\u0069\u006f\u006e\u0073\u005c\u005c\u0045\u0050\u0047\u005c\u005c\u0032\u0030\u0032\u0031\u002d\u0032\u0032\u005c\u005c\u0042\u0033\u005c\u005c\u0049\u0043\u005c\u005c\u0043\u006f\u0075\u0072\u0073\u005c\u005c\u004d\u0061\u0076\u0065\u006e\u0044\u0065\u006d\u006f\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1638732320801L,8589935092L,5,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_3_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
	/**
	 * Constante du message Hello World!
	 */
	// FIXME Doesn't respect code rules
    private final static String message = "Hello World!";

    /**
     * Constructeur par d\u00e9faut
     */
    public App() {try{__CLR4_3_100kwtmwvaf.R.inc(0);}finally{__CLR4_3_100kwtmwvaf.R.flushNeeded();}}

    /**
     * M\u00e9thode de lancement de l'application console
     * @param args Arguments du programme
     */
    public static void main(String[] args) {try{__CLR4_3_100kwtmwvaf.R.inc(1);
        __CLR4_3_100kwtmwvaf.R.inc(2);System.out.println(new App().getMessage());
    }finally{__CLR4_3_100kwtmwvaf.R.flushNeeded();}}

    /**
     * R\u00e9cup\u00e8re la constante du message \u00e0 afficher
     * @return Le message Hello World!
     */
    // TODO remove static
    private static final String getMessage() {try{__CLR4_3_100kwtmwvaf.R.inc(3);
        __CLR4_3_100kwtmwvaf.R.inc(4);return message;
    }finally{__CLR4_3_100kwtmwvaf.R.flushNeeded();}}
}
