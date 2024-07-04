package eu.iamgio.quarkdown.ast

import eu.iamgio.quarkdown.document.page.PageMarginPosition
import eu.iamgio.quarkdown.document.slides.Transition
import eu.iamgio.quarkdown.visitor.node.NodeVisitor

// Nodes introduced by Quarkdown whose rendering does not correspond to a visible output element.

/**
 * A non-visible node that triggers a property in paged documents that allows displaying content on each page.
 * @param children content to be displayed on each page
 * @param position position of the content within the page
 */
data class PageMarginContentInitializer(
    override val children: List<Node>,
    val position: PageMarginPosition,
) : NestableNode {
    override fun <T> accept(visitor: NodeVisitor<T>) = visitor.visit(this)
}

/**
 * A non-visible node that triggers a property in paged documents that allows displaying a page counter on each page.
 * @param content action that returns the text of the counter.
 *                Arguments: index of the current page and total amount of pages.
 *                These are strings instead of numbers since the arguments can be placeholders.
 *                e.g. when using PagedJS for HTML rendering, CSS properties `counter(page)` and `counter(pages)` are used.
 * @param position position of the counter within the page
 */
data class PageCounterInitializer(
    val content: (String, String) -> List<Node>,
    val position: PageMarginPosition,
) : Node {
    override fun <T> accept(visitor: NodeVisitor<T>) = visitor.visit(this)
}

/**
 * A non-visible node that injects properties that affect the global configuration for slides documents.
 * @param centerVertically whether slides should be centered vertically
 * @param showControls whether navigation controls should be shown
 * @param transition global transition between slides
 */
data class SlidesConfigurationInitializer(
    val centerVertically: Boolean?,
    val showControls: Boolean?,
    val transition: Transition?,
) : Node {
    override fun <T> accept(visitor: NodeVisitor<T>) = visitor.visit(this)
}
