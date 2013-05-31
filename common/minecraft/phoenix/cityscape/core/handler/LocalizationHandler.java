package minecraft.phoenix.cityscape.core.handler;

import minecraft.phoenix.cityscape.core.helper.LocalizationHelper;
import minecraft.phoenix.cityscape.core.lib.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 21 Century Mod
 * 
 * LocalizationHandler
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class LocalizationHandler {
	
	/**
	 * Adds language files to language file lib class
	 */
	public static void loadLanguages(){
		for(String LocationFile: Localizations.localeFiles){
			LanguageRegistry.instance().loadLocalization(LocationFile, LocalizationHelper.getLocaleFromFileName(LocationFile), LocalizationHelper.isXMLLanguageFile(LocationFile));
		}
	}
}