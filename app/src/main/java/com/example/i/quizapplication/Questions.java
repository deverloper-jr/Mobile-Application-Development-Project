package com.example.i.quizapplication;

public class Questions {

    public String mQuestions [] = {
            "Which year did Albert Einstein die?",
            "Which is the largest planet in the solar system?",
            "How many Presidents have there been of the USA?",
            "What colour is Cerulean?",
            "What are a group of Dolphins called?",
            "Who invented Penicillin?",
            "What date was President John F Kennedy assassinated?",
            "How many men have walked on the moon?",
            "Who has won the most Academy Awards?",
            "What is the currency of Brazil?",
            "In which decade was the American Institute of Electrical Engineers (AIEE) founded?",
            "What is part of a database that holds only one type of information?",
            "'OS' computer abbreviation usually means ?",
            "In which decade did the first transatlantic radio broadcast occur?",
            "'.MOV' extension refers usually to what kind of file?",
            "Blue is what number on the resistor color code?",
            "Changing computer language of 1's and 0's to characters that a person can understand is...",
            "http://www.auaf.edu.af - is an example of what?",
            "How many bits is a byte?"


    };

    private String mChoices [] [] = {
            {"1954","1949","1960","1955"},
            {"Jupiter","Neptune","Earth","Mars"},
            {"36","29","44","46"},
            {"Red","Blue","Green","Yellow"},
            {"School","Herd","Pod","Pool"},
            {"Alexandra Fleming","Thomas Edison","Marie Curie","George Orwell"},
            {"November 22 1962","November 22 1963","October 29 1964","November 24 1962"},
            {"10","5","12","9"},
            {"James Cameron","Walt Disney","Katherine Hepburn","Steven Spielberg"},
            {"Dollar","The Bhat","Real","Krona"},
            {"1850s","1880s","1930s","1950s"},
            {"Report","Field","Record","File"},
            {"Order of Significance","Open Software","Operating System","Optical Sensor"},
            {"1850s","1860s","1870s","1900s"},
            {"Image file","Animation/movie file","Audio file","MS Office document"},
            {"1","4","2","6"},
            {"Highlight","Clip art","Decode","Execute"},
            {"A URL","An access code","A directory","A server"},
            {"4","8","16","32"}

    };

    private String mCorrectAnswers [] = { "1955", "Jupiter", "44", "Blue", "Pool", "Alexandra Fleming", "November 22 1963" , "12", "Walt Disney","Real", "1880s", "Field", "Operating System", "1900s", "Animation/movie file", "6", "Decode", "A URL", "8"

    };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}

