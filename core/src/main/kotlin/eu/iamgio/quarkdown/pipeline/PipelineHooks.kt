package eu.iamgio.quarkdown.pipeline

import eu.iamgio.quarkdown.ast.AstRoot
import eu.iamgio.quarkdown.lexer.Token

/**
 * Actions to run after each stage of a [Pipeline] has been completed.
 * @param afterLexing action to run after the tokens have been produced (output tokens as arguments)
 * @param afterParsing action to run after the AST has been generated (root as an argument)
 * @param afterExpanding action to run after the queued function calls have been expanded (root as an argument)
 * @param afterRendering action to run after the rendered output code has been generated (output code as an argument)
 * @param afterPostRendering action to run after the rendered output code has been manipulated (e.g. wrapped) (output code as an argument)
 * @see Pipeline
 */
data class PipelineHooks(
    val afterLexing: Pipeline.(List<Token>) -> Unit = {},
    val afterParsing: Pipeline.(AstRoot) -> Unit = {},
    val afterExpanding: Pipeline.(AstRoot) -> Unit = {},
    val afterRendering: Pipeline.(CharSequence) -> Unit = {},
    val afterPostRendering: Pipeline.(CharSequence) -> Unit = {},
)
