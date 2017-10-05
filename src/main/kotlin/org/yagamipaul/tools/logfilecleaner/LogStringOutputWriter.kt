package org.yagamipaul.tools.logfilecleaner

/**
 *
 */
class LogStringOutputWriter(newString: String) : ILogOutputWriter {

    private var data = ""

    override fun end() = Unit

    override fun write(line: String) {
        data+=line
    }


}