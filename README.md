# java-hangul
This is a single-class library for working with Korean Hangul UTF-16 characters in Java.

## Overview
- Use isSyllable and isJamo to determine if any given character is a valid Hangul syllable or jamo.
- Use choseongOf, jungseongOf, and jongseongOf to get each (non-compatibility) jamo from a valid Hangul syllable.
- Use syllableFromJamos to compose a Hangul syllable character from independent Hangul jamo characters.
- Use toCompatibilityJamo to convert any jamo to its compatibility version.

## Todo
- Use standard Java directory structure
- Add package declaration
- Remove main method
- Write more tests
- Inline documentation
- Convenience methods for getting the compatibility jamo of a syllable without requiring two method calls

## More Information
- https://en.wikipedia.org/wiki/Hangul_Jamo_(Unicode_block)
- https://en.wikipedia.org/wiki/Korean_language_and_computers
- https://en.wikipedia.org/wiki/Hangul_Compatibility_Jamo
- http://www.unicode.org/versions/Unicode9.0.0/ch03.pdf
