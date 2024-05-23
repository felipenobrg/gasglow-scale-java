public class GlasgowScale {
    private int eyeOpening;
    private int verbalResponse;
    private int motorResponse;

    public GlasgowScale(int eyeOpening, int verbalResponse, int motorResponse) {
        this.eyeOpening = validateScore(eyeOpening, 1, 4);
        this.verbalResponse = validateScore(verbalResponse, 1, 5);
        this.motorResponse = validateScore(motorResponse, 1, 6);
    }

    private int validateScore(int score, int min, int max) {
        if (score < min || score > max) {
            throw new IllegalArgumentException("Pontuação fora do intervalo permitido.");
        }
        return score;
    }

    public int getEyeOpening() {
        return eyeOpening;
    }

    public int getVerbalResponse() {
        return verbalResponse;
    }

    public int getMotorResponse() {
        return motorResponse;
    }

    public int getTotalScore() {
        return eyeOpening + verbalResponse + motorResponse;
    }

    public String getComaLevel() {
        int totalScore = getTotalScore();
        if (totalScore >= 13 && totalScore <= 15) {
            return "Leve";
        } else if (totalScore >= 9 && totalScore <= 12) {
            return "Moderado";
        } else if (totalScore <= 8) {
            return "Grave";
        } else {
            return "Pontuação inválida";
        }
    }
}
