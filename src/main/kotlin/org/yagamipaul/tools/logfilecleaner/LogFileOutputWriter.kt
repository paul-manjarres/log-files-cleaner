package org.yagamipaul.tools.logfilecleaner

import java.io.File
import java.io.PrintWriter

/**
 *
 */
class LogFileOutputWriter(newfile: File) : ILogOutputWriter {


    /**
     *  The file writer
     */
    private val outputFilePw: PrintWriter = PrintWriter(newfile)


    /**
     * Write a line in the underlying file
     */
    override fun write(line: String) {
        outputFilePw.println(line)
    }

    /**
     * Closes the file
     */
    override fun end() {
        outputFilePw.close()
    }

}