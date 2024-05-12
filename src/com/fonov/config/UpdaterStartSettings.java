package com.fonov.config;

import java.util.Scanner;

public class UpdaterStartSettings {
    private IslandConfig islandConfig;
    private EntityCharacteristicConfig entityCharacteristicConfig;
    private AnimalConfig animalConfig;
    private Scanner scanner;

    public UpdaterStartSettings(IslandConfig islandConfig, EntityCharacteristicConfig entityCharacteristicConfig, AnimalConfig animalConfig) {
        scanner = new Scanner(System.in);
        this.islandConfig = islandConfig;
        this.entityCharacteristicConfig = entityCharacteristicConfig;
        this.animalConfig = animalConfig;
    }

    public void updeteConfig(){
        printStartConfig();
        changeStartConfig();
    }

    private void printStartConfig() {
        System.out.println("Установленные настройки:");
        System.out.println("1. Ширина острова: " + islandConfig.getWidth());
        System.out.println("2. Высота острова: " + islandConfig.getHeight());
        System.out.println("3. Количество дней: " + islandConfig.getDaysOfLife());
        System.out.println("4. Количество детёнышей: " + animalConfig.getCountOfBabyAnimals());
        System.out.println("5. Отнимаемое количесвто жизни за один ход, если животное не поело: " + animalConfig.getPercentToRemove() + "%");
        System.out.println("6. Максимальное количесвто животных на старте:");
        for (var entry : this.entityCharacteristicConfig.getEntityMapConfig().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue().getMaxCountOnField());
        }
        System.out.println();
    }

    private void changeStartConfig() {
        System.out.println("Желаете изменить настройки?(Да/Нет)");
        String answerChangeStartConfig = this.scanner.nextLine();
        boolean checkerAnswerChangeStartConfig = false;
        while (!checkerAnswerChangeStartConfig) {
            if (answerChangeStartConfig.equalsIgnoreCase("Да") || answerChangeStartConfig.equalsIgnoreCase("Нет")) {
                if (answerChangeStartConfig.equalsIgnoreCase("Да")) {
                    choiseCaseForChange();
                    checkerAnswerChangeStartConfig = true;
                    printStartConfig();
                    changeStartConfig();
                } else if (answerChangeStartConfig.equalsIgnoreCase("Нет")) {
                    System.out.println("Игра запускается!");
                    System.out.println();
                    checkerAnswerChangeStartConfig = true;
                }
            } else {
                System.out.println("Введите ответ на вопрос");
                answerChangeStartConfig = scanner.nextLine();
            }
        }
    }

    private void choiseCaseForChange() {
        System.out.println("Введите цифру изменяемого параметра:");
        String answerChoiseParametr = this.scanner.nextLine();
        switch (answerChoiseParametr) {
            case "1": {
                System.out.println("Введите желаемое значение ширины поля");
                islandConfig.setWidth(getTrueIntAnswer(scanner.nextLine()));
                System.out.println("Значение установлено");
                break;

            }
            case "2": {
                System.out.println("Введите желаемое значение высоты поля");
                islandConfig.setHeight(getTrueIntAnswer(scanner.nextLine()));
                System.out.println("Значение установлено");
                break;
            }
            case "3": {
                System.out.println("Введите желаемое значение дней модуляции");

                islandConfig.setDaysOfLife(getTrueIntAnswer(scanner.nextLine()));
                System.out.println("Значение установлено");
                break;
            }
            case "4": {
                System.out.println("Введите желаемое количество детенышей");

                animalConfig.setCountOfBabyAnimals(getTrueIntAnswer(scanner.nextLine()));
                System.out.println("Значение установлено");
                break;
            }
            case "5": {
                System.out.println("Введите отнимаемое количество жизни в процентах");
                animalConfig.setPercentToRemove(getTrueIntAnswer(scanner.nextLine()));
                System.out.println("Значение установлено");
                break;
            }
            case "6": {
                System.out.println("Введите название животного, параметры которого хотите изменить");
                changeAnimalsStartConfig(scanner.nextLine());
                System.out.println("Значение установлено");
                break;
            }
            default: {
                System.out.println("Неккоректная информация. Введите значение изменяемого параметра повторно");
                printStartConfig();
                choiseCaseForChange();
            }
        }
    }

    private Integer getTrueIntAnswer(String answerChangeParametr) {
        while (!isInteger(answerChangeParametr)) {
            System.out.println("Неккоректная информация");
            answerChangeParametr = scanner.nextLine();
        }
        return Integer.parseInt(answerChangeParametr);
    }

    private void changeAnimalsStartConfig(String answerChangeParametrAnimal) {
        boolean animalCountCheck = false;
        for (var entry : entityCharacteristicConfig.getEntityMapConfig().entrySet()) {
            if (entry.getValue().getClass().getSimpleName().equalsIgnoreCase(answerChangeParametrAnimal)) {
                System.out.println("Введите число");
                int answerAmountAnimals = scanner.nextInt();
                entry.getValue().setMaxCountOnField(answerAmountAnimals);
                animalCountCheck = true;
                break;
            }
        }
        if (!animalCountCheck) {
            System.out.println("Неправильные данные, введите повторно данные");
            changeAnimalsStartConfig(scanner.nextLine());
        }

    }

    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}

