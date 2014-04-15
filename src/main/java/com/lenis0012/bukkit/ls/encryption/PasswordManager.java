package com.lenis0012.bukkit.ls.encryption;

import com.lenis0012.bukkit.ls.LoginSecurity;
import com.lenis0012.bukkit.ls.data.DataManager;

public class PasswordManager {
	public static boolean checkPass(String uuid, String password) {
		LoginSecurity plugin = LoginSecurity.instance;
		DataManager data = plugin.data;
		String realPass = data.getPassword(uuid);
		int type = data.getEncryptionTypeId(uuid);
		EncryptionType etype = EncryptionType.fromInt(type);
		return etype.checkPass(password, realPass);
	}
}
