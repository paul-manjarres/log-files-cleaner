package org.yagamipaul.tools.logfilecleaner

import org.apache.commons.cli.*

/**
 * Main method.
 * Used to process the command line arguments.
 *
 * @author Jean Paul Manjarres Correal
 * 
 */
fun main(args: Array<String>) {

    println("Log File Cleaner")


    val options : Options = Options()

    val fileOption : Option = Option.builder("f")
            .hasArg()
            .longOpt("file")
            .desc("The file to process")
            .required()
            .build()

    val stringsOption : Option = Option.builder("sf")
            .hasArg()
            .longOpt("strings")
            .desc("a path to a file containing the strings to match")
            .required()
            .build()


    options.addOption(fileOption)
    options.addOption(stringsOption)

    val parser : CommandLineParser = DefaultParser()
    val commandLine : CommandLine = parser.parse(options, args)


    val filePath = commandLine.getOptionValue("f")
    val stringsPath = commandLine.getOptionValue("sf")

    println("File path : $filePath")
    println("Strings path : $stringsPath")


}


