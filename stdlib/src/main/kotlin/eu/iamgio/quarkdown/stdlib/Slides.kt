package eu.iamgio.quarkdown.stdlib

import eu.iamgio.quarkdown.ast.InlineMarkdownContent
import eu.iamgio.quarkdown.ast.quarkdown.SlidesConfigurationInitializer
import eu.iamgio.quarkdown.ast.quarkdown.SlidesFragment
import eu.iamgio.quarkdown.document.slides.Transition
import eu.iamgio.quarkdown.function.reflect.Name
import eu.iamgio.quarkdown.function.value.NodeValue
import eu.iamgio.quarkdown.function.value.wrappedAsValue

/**
 * `Slides` stdlib module exporter.
 * This module handles slides properties.
 */
val Slides: Module =
    setOf(
        ::setSlidesConfiguration,
        ::fragment,
    )

/**
 * Sets global properties that affect the behavior of a 'slides' document.
 * @param center whether slides should be centered vertically
 * @param showControls whether navigation controls should be shown
 * @param transitionStyle global transition style between slides
 * @param transitionSpeed global transition speed between slides
 * @return a wrapped [SlidesConfigurationInitializer] node
 */
@Name("slides")
fun setSlidesConfiguration(
    center: Boolean? = null,
    @Name("controls") showControls: Boolean? = null,
    @Name("transition") transitionStyle: Transition.Style? = null,
    @Name("speed") transitionSpeed: Transition.Speed = Transition.Speed.DEFAULT,
): NodeValue =
    SlidesConfigurationInitializer(
        center,
        showControls,
        transitionStyle?.let { Transition(it, transitionSpeed) },
    ).wrappedAsValue()

/**
 * Creates an element that, when used in a `slides` document,
 * shows its content when the user attempts to go to the next slide.
 * Multiple fragments in the same slide are shown in order on distinct user interactions.
 * @param content content to show
 * @return the fragment node
 */
fun fragment(content: InlineMarkdownContent) = SlidesFragment(content.children).wrappedAsValue()
