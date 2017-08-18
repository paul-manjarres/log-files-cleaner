package org.yagamipaul.tools.logfilecleaner

import org.apache.commons.cli.*
import java.io.File
import kotlin.system.exitProcess

/**
 * Main method.
 * Used to process the command line arguments.
 *
 * @author Jean Paul Manjarres Correal
 * 
 */
fun main(args: Array<String>) {

    println("Log File Cleaner")

    var app = LogCleanerApp()
    app.startApp(args)

}


