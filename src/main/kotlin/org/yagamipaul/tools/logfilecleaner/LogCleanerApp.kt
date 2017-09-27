package org.yagamipaul.tools.logfilecleaner

import org.apache.commons.cli.*
import org.apache.commons.io.FileUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.yagamipaul.tools.logfilecleaner.dto.AppParameters
import java.io.File
import java.util.ArrayList
import kotlin.system.exitProcess

/**
 * Main class for the app.
 * 2017-08-10
 *
 * @author [Jean Paul Manjarres Correal](paul.manjarres@gmail.com)
 * @since 0.0.1
 */
class LogCleanerApp {


    companion object {
        val LOG = LoggerFactory.getLogger(LogCleanerApp::class.java.name)
    }


    /**
     * Starts the application, process the arguments.
     */
    fun startApp(args: Array<String>) {

        val parameters = processArguments(args)

        // Load the file to process
        var file = File(parameters.filePath)

        if (!file.exists()) {
            println("--> ERROR : The file ${parameters.filePath} doesn't exists")
            exitProcess(1)
        }

        LOG.info("Selected file: ${parameters.filePath}")


        // Load the patterns file

        var patternsFile = File(parameters.patternsPath)

        //TODO: there should be default options for pattern file


        val processor = LogCleanerProcessor(
                inputFile = file,
                outputPath = File(file.parentFile.path),
                patterns = emptySet())

        val results = processor.start()


        println("$results")


    }


    /**
     *  Read a file and get a set of patterns
     */
    fun readPatterns(file: File): Set<String> = file.readLines().toHashSet()



    /**
     * Process the command line arguments passed as an array of strings
     */
    fun processArguments(args: Array<String>): AppParameters {

        val options = Options()

        val fileOption: Option = Option.builder("f")
                .hasArg()
                .longOpt("file")
                .desc("The file to process")
                .required()
                .build()

        val stringsOption: Option = Option.builder("p")
                .hasArg()
                .longOpt("patterns")
                .desc("a path to a file containing the strings to match")
                .required()
                .build()

        options.addOption(fileOption)
        options.addOption(stringsOption)

        val parser: CommandLineParser = DefaultParser()

        try {
            val commandLine: CommandLine = parser.parse(options, args)

            val filePath = commandLine.getOptionValue("f")
            val stringsPath = commandLine.getOptionValue("p")

            LOG.info("File path : $filePath")
            LOG.info("Patterns path : $stringsPath")

            return AppParameters(filePath, stringsPath)

        } catch (ex: MissingOptionException) {

            println("Error: required options not present:  ")
            for (s in ex.missingOptions) {
                println(" - $s")
            }
            exitProcess(1)
        }

    }


}