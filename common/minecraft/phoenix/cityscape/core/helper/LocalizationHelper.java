package minecraft.phoenix.cityscape.core.helper;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 21 Century Mod
 * 
 * LocalizationHelper
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class LocalizationHelper {

	/**
	 * Returns true if is xml file, else false
	 * @param fileName
	 * @return boolean
	 */
	
	public static boolean isXMLLanguageFile(String fileName){
		
		return fileName.endsWith(".xml");
	}

	/**
	 * Gets substring of language file, showing what language it is (EG. en_US)
	 * @param fileName
	 * @return language indicator
	 */
	
	public static String getLocaleFromFileName(String fileName){
		
		return fileName.substring(fileName.lastIndexOf("/")+1,fileName.lastIndexOf("."));
	}

	/**
	 * Gets the key from the language file, which is used to bind ingame name
	 * @param key
	 * @return ingame name
	 */
	
	public static String getLocalizationString(String key){
		
		return LanguageRegistry.instance().getStringLocalization(key);
	}
}