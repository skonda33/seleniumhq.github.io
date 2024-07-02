package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_01_02_how_abstractions_help.end;

import org.openqa.selenium.WebDriver;

import java.util.Random;

class ATodoAppUser {

    private final WebDriver driver;
    private final ATodoAppNavigator navigate;

    public ATodoAppUser(final WebDriver driver) {
        this.driver = driver;
        navigate = new ATodoAppNavigator(driver);
    }

    public void createsATodoList(final String listName) {
        ATodoListsPage todolists =
                navigate.to().todoListsPage();
        todolists.enterTodoListName(listName);
    }

    public String createsATodoList() {
        String listName = new ARandomString("-").generate();
        createsATodoList(listName);
        return listName;
    }

    private class ARandomString {
        private final String space;
        private final int maxWords;
        private final int wordMaxLen;
        private final int wordMinLen;
        private final Random rnd;

        String validchars = "abcdefghijklmnopqrtsuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public ARandomString(String separator){
            this.space = separator;
            this.maxWords = 4;
            this.wordMaxLen = 7;
            this.wordMinLen = 3;
            rnd = new Random();
        }

        public String generate(){

            int wordsToGenerate = rnd.nextInt(maxWords)+1;
            StringBuilder sentence= new StringBuilder();
            String spacer = "";

            while(wordsToGenerate>0){

                sentence.append(spacer);

                int wordLength = rnd.nextInt((wordMaxLen - wordMinLen)+1) + wordMinLen;

                while(wordLength>0){

                    int charIndex = rnd.nextInt(validchars.length());
                    char charToAdd = validchars.charAt(charIndex);
                    sentence.append(charToAdd);
                    wordLength--;
                }

                wordsToGenerate--;
                spacer = space;
            }

            return sentence.toString();
        }

    }
}
