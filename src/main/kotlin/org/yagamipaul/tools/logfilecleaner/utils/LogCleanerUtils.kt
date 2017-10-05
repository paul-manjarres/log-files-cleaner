package org.yagamipaul.tools.logfilecleaner.utils


/**
 * Add a suffix to a file name.
 *
 */
fun addSuffix(fileName: String, suffix: String) : String {
    val index = fileName.lastIndexOf(".")
    val name = fileName.substring(0, index)
    val ext = fileName.substring(index + 1)
    return "$name$suffix.$ext"
}