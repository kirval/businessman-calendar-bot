package calendar.config.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BusinessmanCalendarBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Businessman Calendar Bot";
    }

    @Override
    public String getBotToken() {
        return "1915478954:AAGuVtrP4tXHZ5Qmup3niLrEfKcXIUuUB50";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() &&
                update.getMessage().getText().contains("@BusinessmanCalendarBot") &&
        update.getMessage().getText().contains("работа")) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Шкет сегодня работает, ты что тупой что ли, запомнить сложно?");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
