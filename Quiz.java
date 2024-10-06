import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String question;
    String[] choices;
    int correctAnswerIndex;

    public Question(String question , String[] choices , int correctAnswerIndex)  //constructor
	{
        this.question = question;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class Quiz {
    private List<Question> questions;  //arraylist
    private Scanner scanner;

    public Quiz() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"1. Paris", "2. London", "3. Berlin", "4. Madrid"}, 0));
        questions.add(new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 1));
        questions.add(new Question("What is the color of the sky?", new String[]{"1. Blue", "2. Green", "3. Red", "4. Yellow"}, 0));
    }

    public void start() {
        int score = 0;

        for (Question q : questions) {
            System.out.println(q.question);
            for (String choice : q.choices) {
                System.out.println(choice);
            }
            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt() - 1;

            if (answer == q.correctAnswerIndex) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + (q.correctAnswerIndex + 1) + "\n");
            }
        }

        System.out.println("Quiz over! Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}
