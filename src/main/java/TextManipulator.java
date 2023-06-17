public class TextManipulator {

    public Boolean findTextInParagraph(String text, String paragraph) {

        return paragraph.contains(text);
    }

    public int countTextInParagraph(String text, String paragraph) {

        String[] words = paragraph.split("[^a-zA-Z]+");

        int occurrences = 0;
        for (String word : words) {
            if (word.equals(text)) {
                occurrences++;
            }
        }

        return occurrences;
    }
}
