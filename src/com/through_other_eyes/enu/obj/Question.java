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

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.core.GameCore.QuestionType;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author mwahlhuetter <m.wahl1996 at gmail.com>
 */
public class Question {

    private String questionText;
    private String yesParameter;
    private String noParameter;
    private String additionalQuestion;
    private String additionalQuestionTrigger;

    public Question(String question, String yesParameter, String noParamter, String additionalQuestion, String additionalQuestionTrigger) {
        this.questionText = question;
        this.yesParameter = yesParameter;
        this.noParameter = noParamter;
        this.additionalQuestion = additionalQuestion;
        this.additionalQuestionTrigger = additionalQuestionTrigger;
    }

    /**
     * changes the statistics in the game with the parameters given in the
     * question when yes is pressed
     */
    public void yes() {
        interpretParamter(yesParameter);
    }

    /**
     * changes the statistics in the game with the parameters given in the
     * question when no is pressed
     */
    public void no() {
        interpretParamter(noParameter);
    }

    public void addAdditionalQuestion(QuestionType questionType) {

    }

    /**
     * interprets the parameters
     */
    public void interpretParamter(String parameter) {
        HashMap<String, Country> countries = GameCore.statistics.getCountries();

        String[] parameterValues = parameter.split("#");  //das ist die jeweilige zu veränderte statistik zb gdp oder population
        String[] parameterOptions = null;
        for (int i = 0; i < parameterValues.length; i++) {
            System.out.println(parameterValues[i]);

            parameterOptions = parameterValues[i].split(":");

            switch (parameterOptions[0]) {
                case "population":
                    for (Country country : countries.values()) {
                        if (country.isEuMember()) {
                            if (parameterOptions[3].equals("all")) {
                                country.growPopulation(Double.parseDouble(parameterOptions[1]), parameterOptions[2]);
                            } else {
                                if (country.getName().equals(parameterOptions[3])) {
                                    country.growPopulation(Double.parseDouble(parameterOptions[1]), parameterOptions[2]);
                                }
                            }
                        }
                    }
                    break;
                case "gdp":
                    break;
                case "resign":
                    for (Country country : countries.values()) {
                        if (country.getName().equals(parameterOptions[1])) {
                            country.setEuMember(false);
                        }
                    }
                    break;
                case "join":
                    for (Country country : countries.values()) {
                        if (country.getName().equals(parameterOptions[1])) {
                            country.setEuMember(true);
                        }
                    }
                    break;
                case "liquidate":
                    for (Country country : countries.values()) {
                        country.setEuMember(false);
                    }
                    break;
            }
        }
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getYesParameter() {
        return yesParameter;
    }

    public String getNoParamter() {
        return noParameter;
    }

    public String getAdditionalQuestion() {
        return additionalQuestion;
    }

    public String getAdditionalQuestionTrigger() {
        return additionalQuestionTrigger;
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + questionText + ", yesParameter=" + yesParameter + ", noParamter=" + noParameter + ", additionalQuestion=" + additionalQuestion + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (!Objects.equals(this.questionText, other.questionText)) {
            return false;
        }
        if (!Objects.equals(this.yesParameter, other.yesParameter)) {
            return false;
        }
        if (!Objects.equals(this.noParameter, other.noParameter)) {
            return false;
        }
        if (!Objects.equals(this.additionalQuestion, other.additionalQuestion)) {
            return false;
        }
        return true;
    }
}
