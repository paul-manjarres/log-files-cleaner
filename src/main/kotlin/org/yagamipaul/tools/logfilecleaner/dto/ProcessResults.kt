package org.yagamipaul.tools.logfilecleaner.dto

/**
 * The results of a single cleaning process.
 *
 * @author [Jean Paul Manjarres Correal]
 */
class ProcessResults (
        private val inputFileName:String,
        private val outputFileName: String,
        private val outputFileAbsolutePath: String,
        private val inputFileSizeKB: Long,
        private val outputFileSizeKB: Long,
        private val initialLineCount: Long,
        private val finalLineCount: Long,
        private val millis: Long)