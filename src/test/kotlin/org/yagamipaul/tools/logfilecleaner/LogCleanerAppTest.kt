package org.yagamipaul.tools.logfilecleaner

import org.junit.jupiter.api.Test
import java.io.File

class LogCleanerAppTest{



    @Test
    fun test1() {

        val input = File("classpath:testinputfile.txt")
        val outputPath = File("/tmp/")

        val app = LogCleanerApp(inputFile = input,
                outputPath = outputPath,
                patterns = setOf("aaaaaa", "bbbbbb")
        )

        app.start()


    }

}