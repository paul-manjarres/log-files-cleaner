package org.yagamipaul.tools.logfilecleaner.dto

/**
 * The results of a single cleaning process.
 *
 * @author [Jean Paul Manjarres Correal]
 */
data class ProcessResults(
        val inputFileName: String,
        val outputFileName: String,
        val outputFileAbsolutePath: String,
        val inputFileSizeKB: Long,
        val outputFileSizeKB: Long,
        val initialLineCount: Long,
        val finalLineCount: Long,
        val millis: Long)