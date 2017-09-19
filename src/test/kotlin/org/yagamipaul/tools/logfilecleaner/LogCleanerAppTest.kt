package org.yagamipaul.tools.logfilecleaner

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LogCleanerAppTest {


    @Test
    fun testProcessArguments() {
        val app = LogCleanerApp()
        val results = app.processArguments(arrayOf("-f","file", "-p", "patterns"))
        Assertions.assertEquals(results.filePath, "file")
        Assertions.assertEquals(results.patternsPath, "patterns")
    }


}