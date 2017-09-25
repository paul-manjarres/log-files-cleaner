package org.yagamipaul.tools.logfilecleaner

import org.junit.jupiter.api.Test
import java.io.File

class LogCleanerProcessorTest {



    @Test
    fun test1() {

        val input = File(javaClass.classLoader.getResource("testinputfile.txt").file)
        val outputPath = File("/tmp/")

        val app = LogCleanerProcessor(inputFile = input,
                outputPath = outputPath,
                patterns = setOf("aaaaaa", "bbbbbb")
        )

        app.start()
    }



}