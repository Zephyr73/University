public class Student {
    private String name;
    private int id;
    private double quiz_score, mid_score, final_score;

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getQuiz_score() {
        return quiz_score;
    }
    public double getMid_score() {
        return mid_score;
    }
    public double getFinal_score() {
        return final_score;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setQuiz_score(double quiz_score) {
        if (quiz_score >= 0) {
            this.quiz_score = quiz_score;
        } else {
            System.out.println("Enter a positive value");
        }
    }
    public void setMid_score(double mid_score) {
        if (mid_score >= 0) {
            this.mid_score = mid_score;
        } else {
            System.out.println("Enter a positive value");
        }
    }
    public void setFinal_score(double final_score) {
        if (final_score >= 0) {
            this.final_score = final_score;
        } else {
            System.out.println("Enter a positive value");
        }
    }

    public double calculateFinalAverage() {
        double weighted_average = ((quiz_score * 0.25) + (mid_score * 0.35) + (final_score * 0.40));
        return weighted_average;
    }

    public char getFinalLetterGrade() {
        double weighted_average = calculateFinalAverage();
        if (weighted_average >= 90.0 && weighted_average <= 100) {
            return 'A';
        } else if (weighted_average >= 80 && weighted_average < 90.0) {
            return 'B';
        } else if (weighted_average >= 70 && weighted_average < 80) {
            return 'C';
        } else if (weighted_average >= 60 && weighted_average < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }
}