package eu.iamgio.quarkdown.flavor

/**
 *
 */
interface MarkdownFlavor {
    val lexerFactory: LexerFactory
    val parserFactory: ParserFactory
}
