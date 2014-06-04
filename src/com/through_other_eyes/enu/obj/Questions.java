/*
 * Copyright (C) 2014 mwahlhuetter <m.wahl1996 at gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore.QuestionType;
import com.through_other_eyes.enu.obj.base.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mwahlhuetter <m.wahl1996 at gmail.com>
 */
public class Questions {

    private ArrayList<Question> centralBankQuestions = new ArrayList<>();
    private ArrayList<Question> courtHouseQuestions = new ArrayList<>();
    private ArrayList<Question> europeanParliamentQuestions = new ArrayList<>();
    private ArrayList<Question> europeanCommissionQuestions = new ArrayList<>();
    private Random rand;

    public Questions() throws IOException {
        rand = new Random();
    }

//    public Question getCentralBankQuestion() {
//        Question question = centralBankQuestions.get(rand.nextInt(centralBankQuestions.size() - 1));
//        centralBankQuestions.remove(question);
//        return question;
//    }
//
//    public Question getCourtHouseQuestion() {
//        Question question = courtHouseQuestions.get(rand.nextInt(courtHouseQuestions.size() - 1));
//        courtHouseQuestions.remove(question);
//        return question;
//    }
//
//    public Question getEuropeanParliamentQuestion() {
//        Question question = europeanParliamentQuestions.get(rand.nextInt(europeanParliamentQuestions.size() - 1));
//        europeanParliamentQuestions.remove(question);
//        return question;
//    }
//
//    public Question getEuropeanCommissionQuestion() {
//        Question question = europeanCommissionQuestions.get(rand.nextInt(europeanCommissionQuestions.size() - 1));
//        europeanCommissionQuestions.remove(question);
//        return question;
//    }
    private enum QuestionData {

        INSTITUTION(0), QUESTION(1), YES(2), NO(3), ADDITIONAL_QUESTION_TRIGGER(4), ADDITIONAL_QUESTION(5);

        private int value;

        QuestionData(int value) {
            this.value = value;
        }

        public int getNumVal() {
            return value;
        }
    }

//    /**
//     * starts the initialization process of the questions
//     * @throws IOException 
//     */
//    private void initializeQuestions() throws IOException {
//        loadQuestions();
//        Thread interpretQuestionParamter = new Thread() {
//                @Override
//                public void run() {
//                    for(Question question : centralBankQuestions)
//                    {
//                        question.interpretParamter();
//                    }
//                    for(Question question : courtHouseQuestions)
//                    {
//                        question.interpretParamter();
//                    }
//                    for(Question question : europeanParliamentQuestions)
//                    {
//                        question.interpretParamter();
//                    }
//                    for(Question question : europeanCommissionQuestions)
//                    {
//                        question.interpretParamter();
//                    }
//                }
//            };
//            interpretQuestionParamter.start();
//    }
    /**
     * loads all questions from a file to the respective list
     *
     * @throws IOException
     */
    public void loadQuestions() throws IOException {
        FileReader fr = new FileReader(Resource.QUESTION_DATA);
        BufferedReader br = new BufferedReader(fr);
        String line = "";

        while ((line = br.readLine()) != null) {
            String[] questionDataLine = line.split(";");
            switch (questionDataLine[QuestionData.INSTITUTION.value]) {
                case "ecb":
                    centralBankQuestions.add(parseQuestion(questionDataLine));
                    break;
                case "ech":
                    courtHouseQuestions.add(parseQuestion(questionDataLine));
                    break;
                case "eup":
                    europeanParliamentQuestions.add(parseQuestion(questionDataLine));
                    break;
                case "euc":
                    europeanCommissionQuestions.add(parseQuestion(questionDataLine));
                    break;
            }
        }
    }

    /**
     * makes a new Question object with given parameters, for reducing code
     * multiply
     *
     * @param questionDataLine
     * @return a new Question object is returned
     */
    public Question parseQuestion(String[] questionDataLine) {
        if (questionDataLine[QuestionData.ADDITIONAL_QUESTION_TRIGGER.value].equals("null")) {
            return new Question(questionDataLine[QuestionData.QUESTION.value], questionDataLine[QuestionData.YES.value], questionDataLine[QuestionData.NO.value], "null", "null");
        }
        else
        {
          return new Question(questionDataLine[QuestionData.QUESTION.value], questionDataLine[QuestionData.YES.value], questionDataLine[QuestionData.NO.value], questionDataLine[QuestionData.ADDITIONAL_QUESTION.value], questionDataLine[QuestionData.ADDITIONAL_QUESTION_TRIGGER.value]);
        }
    }

    public Question getNextQuestion(QuestionType questionType) {
        Question question = null;
        switch (questionType) {
            case CENTRALBANK:
                if (centralBankQuestions.isEmpty()) {
                    return null;
                } else {
                    question = centralBankQuestions.get(rand.nextInt(centralBankQuestions.size()));
                    return question;
                }
            case COURTHOUSE:
                if (courtHouseQuestions.isEmpty()) {
                    return null;
                } else {
                    question = courtHouseQuestions.get(rand.nextInt(courtHouseQuestions.size()));
                    return question;
                }
            case EUROPEAN_PARLIAMENT:
                if (europeanParliamentQuestions.isEmpty()) {
                    return null;
                } else {
                    question = europeanParliamentQuestions.get(rand.nextInt(europeanParliamentQuestions.size()));
                    return question;
                }
            case EUROPEAN_COMMISSION:
                if (europeanCommissionQuestions.isEmpty()) {
                    return null;
                } else {
                    question = europeanCommissionQuestions.get(rand.nextInt(europeanCommissionQuestions.size()));
                    return question;
                }
        }
        return null;
    }

    /**
     * removes question from list specified with questiontype param. Gets
     * normally called after question is answered.
     *
     * @param question
     * @param questionType
     */
    public void removeQuestion(Question question, QuestionType questionType) {
        switch (questionType) {
            case CENTRALBANK:
                centralBankQuestions.remove(question);
                break;
            case COURTHOUSE:
                courtHouseQuestions.remove(question);
                break;
            case EUROPEAN_PARLIAMENT:
                europeanParliamentQuestions.remove(question);
                break;
            case EUROPEAN_COMMISSION:
                europeanCommissionQuestions.remove(question);
                break;
        }
    }

    /**
     * removes all questions in all 4 list. called wehen new game is started
     */
    public void clearQuestions() {
        centralBankQuestions.clear();
        courtHouseQuestions.clear();
        europeanParliamentQuestions.clear();
        europeanCommissionQuestions.clear();
    }
}
