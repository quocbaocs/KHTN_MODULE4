package controllers;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Code to generate page ids. IdGenerators are expensive to setup so it is
 * suggested that you share instances wherever possible. This action will also
 * enhance security. Much of this code is adapted from
 * org.apache.catalina.session.ManagerBase. Specifically Revision 1.37 which has
 * been unchanged in the past 18 months. I have taken out the /dev/urandom stuff
 * and simplified things to the point where we can audit it to work out what
 * might be broken.
 * 
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class IdGenerator {
	public static String RandGeneratedStr(int l)

	{
		return RandomStringUtils.random(l,"qwertyuiopljlkjhgfdsazxcvbmASDFGHJKLPOIUYTREWQZXCVBNM1234567890");
	}
	public static void main(String[] args) {
		System.out.println(RandGeneratedStr(32));
	}

}