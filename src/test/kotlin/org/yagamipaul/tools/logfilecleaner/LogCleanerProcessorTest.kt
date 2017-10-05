package org.yagamipaul.tools.logfilecleaner

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.yagamipaul.tools.logfilecleaner.utils.addSuffix
import java.io.File

class LogCleanerProcessorTest {


    @Test
    fun test1() {

        val input = File(javaClass.classLoader.getResource("testinputfile.txt").file)
        val outputPath = File("/tmp/")

        val app = LogCleanerProcessor(
                inputFile = input,
                outputPath = outputPath,
                patterns = setOf("aaaaaa", "bbbbbb")
        )

        val results = app.start()
        Assertions.assertEquals(10, results.initialLineCount)
        Assertions.assertEquals(6, results.finalLineCount)

    }

    @Test
    fun assertThatAddSuffixWorks() {
        val name = "file.txt"
        val suffix = "_CLEANED"
        val result = addSuffix(name, suffix)
        Assertions.assertEquals("file$suffix.txt", result)
    }


}