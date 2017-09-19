package org.yagamipaul.tools.logfilecleaner

/**
 *
 */
interface ILogOutputWriter {


    /**
     * Write a line
     */
    fun write(line: String)


    /**
     * Close the resources
     */
    fun end()

}
