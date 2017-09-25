package org.yagamipaul.tools.logfilecleaner

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class LogCleanerAppTest {


    @Test
    fun testProcessArguments() {
        val app = LogCleanerApp()
        val results = app.processArguments(arrayOf("-f","file", "-p", "patterns"))
        Assertions.assertEquals(results.filePath, "file")
        Assertions.assertEquals(results.patternsPath, "patterns")
    }


    @Test
    fun testThatPatternsLoadAsASetOfStrings(){
        val patternsFile = File(javaClass.classLoader.getResource("testpatterns.txt").file)
        val patterns = LogCleanerApp().readPatterns(patternsFile)
        Assertions.assertEquals(2, patterns.size)
        Assertions.assertTrue(patterns.contains("aaaaaa"))
        Assertions.assertTrue(patterns.contains("bbbbbb"))
    }

}