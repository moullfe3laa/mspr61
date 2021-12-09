package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Classe de tests du projet de démo Maven/Jenkins
 * @author MM Formations 
 */
public class AppTest
{
	/**
	 * Flux de sortie des messages de la classe de tests
	 */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Instancie le flux de sortie avant l'exécution des tests
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent)); 
    }

    /**
     * Constructeur par défaut
     */
    @Test
    public void testAppConstructor() {
        try {
            new App();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }
    
    /**
     * 
     */
    @Test
    public void testAppMain()
    {
        App.main(null);
        try {
            assertEquals("Hello World!" + System.getProperty("line.separator"), outContent.toString());
        } catch (AssertionError e) {
            fail("\"message\" is not \"Hello World!\"");
        }
    }

    /**
     * Désalloue le flux de sortie après l'exécution des tests
     */
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
