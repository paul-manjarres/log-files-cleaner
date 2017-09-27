package org.yagamipaul.tools.logfilecleaner

import com.google.common.base.Stopwatch
import org.apache.commons.io.FileUtils
import org.apache.commons.io.LineIterator
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import org.yagamipaul.tools.logfilecleaner.dto.ProcessResults
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Processor
 * 2017-08-10
 *
 * @author [Jean Paul Manjarres Correal](paul.manjarres@gmail.com)
 * @since 0.0.1
 */
class LogCleanerProcessor (
        val inputFile: File,
        val outputPath: File,
        val patterns: Set<String>) {



    companion object {
        val LOG = LoggerFactory.getLogger(LogCleanerProcessor::class.java.name)
    }

    /**
     * Suffix for the cleaned files
     */
    private val SUFFIX: String = "_CLEANED"


    /**
     * Starts the cleaning process
     */
    fun start() : ProcessResults {


        val fileName = inputFile.name
        val index = fileName.lastIndexOf(".")
        val name = fileName.substring(0, index)
        val ext = fileName.substring(index + 1)

        val outputFileName = "$name$SUFFIX.$ext"
        val outputFile = File(this.outputPath.absolutePath + File.separator + outputFileName)


        val timer: Stopwatch = Stopwatch.createStarted()

        LOG.info("File: ${inputFile.name} Size: ${inputFile.length() / 1024}")


        val writer : ILogOutputWriter = LogFileOutputWriter(outputFile)
        val it : LineIterator =  FileUtils.lineIterator(inputFile, "UTF-8")

        var lineCount = 0L
        var writtenLineCount = 0L

        try {
            while (it.hasNext()) {
                val line = it.nextLine()
                var remove = false

                for ( s in  patterns) {
                    if (StringUtils.contains(line, s)) {
                        remove = true
                        break
                    }
                }

                if (!remove) {
                    writer.write(line)
                    writtenLineCount++
                }
                lineCount++
            }
        }
        finally {
            LineIterator.closeQuietly(it)
            writer.end()
        }



        timer.stop()

        LOG.info("Total ellapsed time: ${timer.elapsed(TimeUnit.MILLISECONDS)} ms")


        return ProcessResults(
                inputFileName = inputFile.absolutePath,
                outputFileName = outputFileName,
                outputFileAbsolutePath = outputFile.absolutePath,
                inputFileSizeKB = inputFile.length() / 1024L,
                outputFileSizeKB = outputFile.length() / 1024L,
                initialLineCount = lineCount,
                finalLineCount = writtenLineCount,
                millis = timer.elapsed(TimeUnit.MILLISECONDS)
        )
    }

}