package ru.rsreu.vkr.command.client;
import ru.rsreu.vkr.command.ActionCommand;
import ru.rsreu.vkr.command.LoginCommand;
import ru.rsreu.vkr.command.LogoutCommand;
import ru.rsreu.vkr.command.MainCommand;
import ru.rsreu.vkr.command.ProfileCommand;
import ru.rsreu.vkr.command.CountCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	PROFILE {
		{
			this.command = new ProfileCommand();
		}
	},
	MAIN {
		{
			this.command = new MainCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	COUNT {
		{
			this.command = new CountCommand();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}