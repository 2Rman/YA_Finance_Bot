# YA_Finance_Bot
A simple Telegram bot. It's main goal is to calcualte savings which my wife's studio earns.

ver 0.0.1
To start working with this bot you should add file "application.properties" into directory "resourses". 
This file contains such necessary properties as "bot.username" and "bot.token".
These credentials you can get from bot "BotFather" (TelegramBot)

ver 1.0.0
The "application.properties" file should contain property "chat.id". It made to protect your own chat from unintentional usage by other users
Also my bot was deployed on ubuntu server, and I put it into "/home/user/ya_bot" directory. So this path is hard coded into a static variable.
Near the jar file should be file "data.json" which contains information of the following type:

{"chatId":"0","savings":"0.0","debt":"0.0","balance":"0.0"}

The application will periodically save data into the same file to protect your data from losing if the app crashes
