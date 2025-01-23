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
        if (!isSyllable(ch)) throw new Exception(String.format("'%c' is not a valid hangul syllable", ch));

        int syllableOffset = (int)ch - syllableStart;
        return (char)(choseongStart + syllableOffset / latterCount);
    }

    public static char jungseongOf(char ch) throws Exception {
        if (!isSyllable(ch)) throw new Exception(String.format("'%c' is not a valid hangul syllable", ch));

        int syllableOffset = (int)ch - syllableStart;
        return (char)(jungseongStart + (syllableOffset % latterCount) / jongseongCount);
    }

    public static char jongseongOf(char ch) throws Exception {
        if (!isSyllable(ch)) throw new Exception(String.format("'%c' is not a valid hangul syllable", ch));

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
            case 'ㄳ', 'ᆪ' -> 'ㄳ';
            case 'ㄸ', 'ᄄ' -> 'ㄸ';
            case 'ㅃ', 'ᄈ' -> 'ㅃ';
            case 'ㅄ', 'ᆹ', -> 'ㅄ';
            case 'ㅉ', 'ᄍ' -> 'ㅉ';
            case 'ㄵ', 'ᆬ' -> 'ㄵ';
            case 'ㄶ', 'ᆭ' -> 'ㄶ';
            case 'ㄺ', 'ᆰ' -> 'ㄺ';
            case 'ㄻ', 'ᆱ', -> 'ㄻ';
            case 'ㄼ', 'ᆲ' -> 'ㄼ';
            case 'ㄽ', 'ᆳ', -> 'ㄽ';
            case 'ㄾ', 'ᆴ', -> 'ㄾ';
            case 'ㄿ', 'ᆵ', -> 'ㄿ';
            case 'ㅀ', 'ᆶ', -> 'ㅀ';

            case 'ㅏ', 'ᅡ' -> 'ㅏ';
            case 'ㅐ', 'ᅢ' -> 'ㅐ';
            case 'ㅑ', 'ᅣ' -> 'ㅑ';
            case 'ㅒ', 'ᅤ' -> 'ㅐ';
            case 'ㅓ', 'ᅥ', -> 'ㅓ';
            case 'ㅔ', 'ᅦ' -> 'ㅔ';
            case 'ㅕ', 'ᅧ' -> 'ㅕ';
            case 'ㅖ', 'ᅨ' -> 'ㅔ';
            case 'ㅗ', 'ᅩ' -> 'ㅗ';
            case 'ㅘ', 'ᅪ', -> 'ㅘ';
            case 'ㅙ', 'ᅫ' -> 'ㅙ';
            case 'ㅚ', 'ᅬ' -> 'ㅚ';
            case 'ㅛ', 'ᅭ' -> 'ㅛ';
            case 'ㅜ', 'ᅮ', -> 'ㅜ';
            case 'ㅝ', 'ᅯ' -> 'ㅝ';
            case 'ㅞ', 'ᅰ' -> 'ㅞ';
            case 'ㅟ', 'ᅰ' -> 'ㅟ';
            case 'ㅠ', 'ᅲ', -> 'ᅲ';
            case 'ㅡ', 'ᅳ', -> 'ㅡ';
            case 'ㅢ', 'ᅴ' -> 'ㅢ';
            case 'ㅣ', 'ᅵ' -> 'ㅣ';
            
            default -> throw new Exception(String.format("'%c' is not a valid jamo", ch));
        };
    }

    public static char syllableFromJamos(char choseong, char jungseong, char jongseong) throws Exception {
        return (char)(
                (choseongValue(choseong)) * latterValue
                + (jungseongValue(jungseong)) * jongseongCount
                + jongseongValue(jongseong)
                );
    }

    public static char syllableFromJamos(char choseong, char jungseong) throws Exception {
        return (char)(
                (choseongValue(choseong)) * latterValue
                + (jungseongValue(jungseong)) * jongseongCount
                );
    }

    private static int choseongValue(char ch) throws Exception {
        char compatibilityJamo = toCompatibilityJamo(ch);
        return switch (compatibilityJamo) {
            case 'ㄱ' -> 0;
            case 'ㄲ' -> 1;
            case 'ㄴ' -> 2;
            case 'ㄷ' -> 3;
            case 'ㄸ' -> 4;
            case 'ㄹ' -> 5;
            case 'ㅁ' -> 6;
            case 'ㅂ' -> 7;
            case 'ㅃ' -> 8;
            case 'ㅅ' -> 9;
            case 'ㅆ' -> 10;
            case 'ㅇ' -> 11;
            case 'ㅈ' -> 12;
            case 'ㅉ' -> 13;
            case 'ㅊ' -> 14;
            case 'ㅋ' -> 15;
            case 'ㅌ' -> 16;
            case 'ㅍ' -> 17;
            case 'ㅎ' -> 18;
            default -> throw new Exception("'%c' is not a valid choseong");
        };
    }

    private static int jungseongValue(char ch) throws Exception {
        char compatibilityJamo = toCompatibilityJamo(ch);
        return switch (compatibilityJamo) {
            case 'ㅏ' -> 0;
            case 'ㅐ' -> 1;
            case 'ㅑ' -> 2;
            case 'ㅒ' -> 3;
            case 'ㅓ' -> 4;
            case 'ㅔ' -> 5;
            case 'ㅕ' -> 6;
            case 'ㅖ' -> 7;
            case 'ㅗ' -> 8;
            case 'ㅘ' -> 9;
            case 'ㅙ' -> 10;
            case 'ㅚ' -> 11;
            case 'ㅛ' -> 12;
            case 'ㅜ' -> 13;
            case 'ㅝ' -> 14;
            case 'ㅞ' -> 15;
            case 'ㅟ' -> 16;
            case 'ㅠ' -> 17;
            case 'ㅡ' -> 18;
            case 'ㅢ' -> 19;
            case 'ㅣ' -> 20;
            default -> throw new Exception("'%c' is not a valid jungseong");
        };
    }

    private static int jongseongValue(char ch) throws Exception {
        char compatibilityJamo = toCompatibilityJamo(ch);
        return switch (compatibilityJamo) {
            case 'ㄱ' -> 1;
            case 'ㄲ' -> 2;
            case 'ㄳ' -> 3;
            case 'ㄴ' -> 4;
            case 'ㄵ' -> 5;
            case 'ㄶ' -> 6;
            case 'ㄷ' -> 7;
            case 'ㄹ' -> 8;
            case 'ㄺ' -> 9;
            case 'ㄻ' -> 10;
            case 'ㄼ' -> 11;
            case 'ㄽ' -> 12;
            case 'ㄾ' -> 13;
            case 'ㄿ' -> 14;
            case 'ㅀ' -> 15;
            case 'ㅁ' -> 16;
            case 'ㅂ' -> 17;
            case 'ㅄ' -> 18;
            case 'ㅅ' -> 19;
            case 'ㅆ' -> 20;
            case 'ㅇ' -> 21;
            case 'ㅈ' -> 22;
            case 'ㅊ' -> 23;
            case 'ㅋ' -> 24;
            case 'ㅌ' -> 25;
            case 'ㅍ' -> 26;
            case 'ㅎ' -> 27;
            default -> throw new Exception("'%c' is not a valid jongseong");
        };
    }
}
