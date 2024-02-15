package eu.iamgio.quarkdown.common

import eu.iamgio.quarkdown.lexer.BlockCodeToken
import eu.iamgio.quarkdown.lexer.BlockQuoteToken
import eu.iamgio.quarkdown.lexer.BlockTextToken
import eu.iamgio.quarkdown.lexer.FencesCodeToken
import eu.iamgio.quarkdown.lexer.HeadingToken
import eu.iamgio.quarkdown.lexer.HorizontalRuleToken
import eu.iamgio.quarkdown.lexer.HtmlToken
import eu.iamgio.quarkdown.lexer.LinkDefinitionToken
import eu.iamgio.quarkdown.lexer.ListItemToken
import eu.iamgio.quarkdown.lexer.NewlineToken
import eu.iamgio.quarkdown.lexer.ParagraphToken
import eu.iamgio.quarkdown.lexer.SetextHeadingToken

/**
 * A visitor for block [eu.iamgio.quarkdown.lexer.TokenDecorator]s.
 * @param T output type of the `visit` methods
 */
interface BlockTokenVisitor<T> {
    fun visit(token: NewlineToken): T

    fun visit(token: BlockCodeToken): T

    fun visit(token: FencesCodeToken): T

    fun visit(token: HorizontalRuleToken): T

    fun visit(token: HeadingToken): T

    fun visit(token: SetextHeadingToken): T

    fun visit(token: LinkDefinitionToken): T

    fun visit(token: ListItemToken): T

    fun visit(token: HtmlToken): T

    fun visit(token: ParagraphToken): T

    fun visit(token: BlockQuoteToken): T

    fun visit(token: BlockTextToken): T
}
