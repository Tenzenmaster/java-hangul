public class Hangul {
    private static final int syllableStart = 0xAC00;
    private static final int syllableEnd = 0xD7AF;
    private static final int syllableCount = syllableEnd - syllableStart + 1;

    private static final int choseongStart = 0x1100;
    private static final int choseongEnd = 0x1112;
    private static final int choseongCount = 19;

    private static final int jungseongStart = 0x1161;
    private static final int jungseongEnd = 0x1175;
    private static final int jungseongCount = 21;

    private static final int jongseongStart = 0x11A7;
    private static final int jongseongEnd = 0x11C2;
    private static final int jongseongCount = 28;

    private static final int compatibilityJamoStart = 0x3131;
    private static final int compatibilityJamoEnd = 0x318E;
    private static final int compatibilityJamoCount = 94;

    private static final int latterCount = 588;

    public static void main(String[] args) throws Exception {
        assert isSyllable('가');
        assert isSyllable('안');
        assert isSyllable('환');
        assert !isSyllable('ㄱ');
        assert !isSyllable('ㅣ');
        assert !isSyllable('a');
        assert jongseongCount == 28;

        char syllable = args[1].charAt(0);
        char choseong = choseongOf(syllable);
        char jungseong = jungseongOf(syllable);
        char jongseong = jongseongOf(syllable);

        System.out.printf("%c -> %c %c %c\n", syllable, choseong, jungseong, jongseong);
    }

    public static boolean isSyllable(char ch) {
        return ch >= syllableStart && ch <= syllableEnd;
    }

    public static boolean isJamo(char ch) {
        return (ch >= choseongStart && ch <= choseongEnd)
            || (ch >= jungseongStart && ch <= jungseongEnd)
            || (ch >= jongseongStart && ch <= jongseongEnd)
            || (ch >= compatibilityJamoStart && ch <= compatibilityJamoEnd);
    }

    public static char choseongOf(char ch) throws Exception {
        if (!isSyllable(ch)) throw new Exception(String.format("%c is not a valid hangul syllable", ch));

        int syllableOffset = (int)ch - syllableStart;
        return (char)(choseongStart + syllableOffset / latterCount);
    }

    public static char jungseongOf(char ch) throws Exception {
        if (!isSyllable(ch)) throw new Exception(String.format("%c is not a valid hangul syllable", ch));

        int syllableOffset = (int)ch - syllableStart;
        return (char)(jungseongStart + (syllableOffset % latterCount) / jongseongCount);
    }

    public static char jongseongOf(char ch) throws Exception {
        if (!isSyllable(ch)) throw new Exception(String.format("%c is not a valid hangul syllable", ch));

        int syllableOffset = (int)ch - syllableStart;
        int jongseong = jongseongStart + (syllableOffset % jongseongCount);
        if (jongseong != jongseongStart) return (char)jongseong;
        else return '\0';
    }

    public static char toCompatibilityJamo(char ch) throws Exception {
        return switch (ch) {
            case 'ㄱ', 'ᄀ', 'ᆨ' -> 'ㄱ';
            case 'ㄴ', 'ᄂ', 'ᆫ' -> 'ㄴ';
            case 'ㄷ', 'ᄃ', 'ᆮ' -> 'ㄷ';
            case 'ㄹ', 'ᄅ', 'ᆯ' -> 'ㄹ';
            case 'ㅁ', 'ᄆ', 'ᆷ' -> 'ㅁ';
            case 'ㅂ', 'ᄇ', 'ᆸ' -> 'ㅂ';
            case 'ㅅ', 'ᄉ', 'ᆻ' -> 'ㅅ';
            case 'ㅇ', 'ᄋ', 'ᆼ' -> 'ㅇ';
            case 'ㅈ', 'ᄌ', 'ᆽ' -> 'ㅈ';
            case 'ㅊ', 'ᄎ', 'ᆾ' -> 'ㅊ';
            case 'ㅋ', 'ᄏ', 'ᆿ' -> 'ㅋ';
            case 'ㅌ', 'ᄐ', 'ᇀ' -> 'ㅌ';
            case 'ㅍ', 'ᄑ', 'ᇁ' -> 'ㅍ';
            case 'ㅎ', 'ᄒ', 'ᇂ' -> 'ㅎ';

            case 'ㄲ', 'ᄁ', 'ᆩ' -> 'ㄲ';
            case 'ㄳ', 'ᆪ', -> 'ㄳ';
            case 'ㄸ', 'ᄄ' -> 'ㄸ';
            case 'ㅃ', 'ᄈ' -> 'ㅃ';
            case 'ㅉ', 'ᄍ', -> 'ㅉ';
            case 'ㄵ', 'ᆬ', -> 'ㄵ';
            
            default -> throw new Exception(String.format("%c is not a valid jamo", ch));
        };
    }
}
