package eu.iamgio.quarkdown

import eu.iamgio.quarkdown.ast.Document
import eu.iamgio.quarkdown.lexer.BlockLexer
import eu.iamgio.quarkdown.log.DebugFormatter
import eu.iamgio.quarkdown.log.Log
import eu.iamgio.quarkdown.parser.BlockTokenParser
import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        Log.error("No source file passed.")
        exitProcess(NO_SOURCE_FILE_EXIT_CODE)
    }

    val sourceFile = File(args.first())

    val lexer = BlockLexer(sourceFile.readText())
    val tokens = lexer.tokenize()

    Log.debug("Tokens: \n" + DebugFormatter.formatTokens(tokens))

    val document = Document(children = tokens.map { it.parse(BlockTokenParser()) })

    Log.debug(document)
}
