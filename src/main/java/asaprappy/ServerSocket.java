package asaprappy;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.tomcat.jni.Socket;

import javafx.util.Pair;


@ServerEndpoint(value = "/ws")

public class ServerSocket {

	private static Vector<Pair<Session, String>> sessionVector = new Vector<Pair<Session, String>>();
	private Data dob = new Data();

	
	String[] screenNames = {"Whoopy Panda", 
			"Dimple Doll", 
			"Crazy KupKakes", 
			"Squiggly Munchkin", 
			"Sizzlin Teapot", 
			"Gold Queenie", 
			"Pinkie Cutie", 
			"Dodo Chip", 
			"Gummielicious Bling", 
			"Brown Hunnie", 
			"Fizzy Brown", 
			"Scribbly Lightning", 
			"Panda Heart", 
			"Sweet Whimsy", 
			"Ninja Rock", 
			"Secret Fruity", 
			"Blossom Cotton", 
			"Ice Huggy", 
			"Forever Bubblegum", 
			"Delicious Raspberry", 
			"Fruity Charm", 
			"Diva Tulips", 
			"Super Giggles", 
			"Butterscotch Seven", 
			"Sleepy Tinker", 
			"Fudgy Turkey", 
			"Mayflower Madame", 
			"Mystical Dimples", 
			"Kute Poopie", 
			"Twittie Sparkles", 
			"Tiger Swirlie", 
			"Triple Adorable", 
			"Bedazzzled Blue", 
			"Piggy Twinkling", 
			"Glitzy Go", 
			"Cream Smiley", 
			"Cupcake Hugs", 
			"Fairytale Daisy", 
			"Tigger Fresh", 
			"Pickle Pinkest", 
			"Dazzlin Princess", 
			"Happy Muah", 
			"Shy Snicker", 
			"Furry Dimples", 
			"Live Chic", 
			"Happy Wow", 
			"Lil Cutie", 
			"Wabbit Cherry", 
			"Prinky Doodsie", 
			"Teddie Doc", 
			"Secret Snowy", 
			"Cupid Hot", 
			"Frisbee Doodsie", 
			"Bunny Passion", 
			"Chocolatey Smile", 
			"Dimple Caramel", 
			"Petty Picnic", 
			"One Chewy", 
			"Prinky Shortiepants", 
			"Sugary Heaven", 
			"Tickle Star", 
			"Pretty Pumpkin", 
			"Warm Sunflower", 
			"Golden Tickle", 
			"Daisy Ladybird", 
			"Forever Choco", 
			"Blushy Pinkest", 
			"Circus Halo", 
			"Jelly Snowballs", 
			"Pickle Raindrops", 
			"Flying Cupid", 
			"Neon Girl", 
			"Gold Cherry", 
			"Mmm Tank", 
			"Squishy Bionic", 
			"Doozles Fairy", 
			"Honey Sparky", 
			"Beach Bionic", 
			"Songbird Garden", 
			"Peanut Mockingbird", 
			"Waffle Glitter", 
			"Icing Crystal", 
			"Rainbow Sweety", 
			"Waffle Friends", 
			"Dandelion Monster", 
			"Boogie Lollipop", 
			"Twin Dazzlin", 
			"Sugar Genius", 
			"Shiny Soo", 
			"Golden Tee", 
			"Snuggle Kitty", 
			"Gold Jewel", 
			"Dazzlin Snuggle", 
			"Genie Dolphin", 
			"Fluffy Marshmallow", 
			"Fuzzie Cherry", 
			"Magic Pizza", 
			"Delicious Cinnamon", 
			"Furry Fairytale", 
			"Chicky Kute", 
			"Spring Lucky", 
			"Star Cherrie", 
			"Miss Turkey", 
			"Autumn Spring", 
			"Secret Giggle", 
			"Raspberry Fortune", 
			"Twinkling Muah", 
			"Sweetie Wow", 
			"Trixie Grizzly", 
			"Squishy Doll", 
			"Jelly Cuddles", 
			"Boogie Neon", 
			"Hugsie Princess", 
			"Tweetie Peachie", 
			"Twilight Queenbee", 
			"Jelly Bubbly", 
			"Sugarplum Chum", 
			"Sweet Hey", 
			"Hunnie Froggie", 
			"Breezy Boo", 
			"Raspberry Trixie", 
			"Huggable Babe", 
			"Jazzie Flip", 
			"Mega Mayhem", 
			"Princess Munchkin", 
			"Me Mini", 
			"Cream Twinkie", 
			"Tiny Bubble", 
			"Cookee Chicky", 
			"Banana Fizzy", 
			"Queen Doodsie", 
			"Flip Hug", 
			"Grinning Prinky", 
			"Icy Peppermint", 
			"Blueberrie Ham", 
			"Vanilla Angelic", 
			"Girlie Chum", 
			"Cutie Bun", 
			"Fudgy Karot", 
			"Snowflakes Mega", 
			"Fancy Hunny", 
			"Polka Pinky", 
			"Dazzzled Sweetie", 
			"Scooby Bumble", 
			"Candycane Missy", 
			"Triple Girly", 
			"Tiger Kitty", 
			"Qwerty Bells", 
			"Chicken Cuddles", 
			"Bubbling Clumzie", 
			"Chatterbug Megastar", 
			"Squeezie Teapot", 
			"Dizzy Smilie", 
			"Glitzy Piggy", 
			"Magic Peach", 
			"Orange Cookie", 
			"Ultimate Angelstar", 
			"Huggable Pickle", 
			"Melon Passion", 
			"Frog Cherry", 
			"Soft Mambo", 
			"Blondie Button", 
			"Cosmopolitan Twinkles", 
			"Sweet Pearl", 
			"Sugarplum Dimple", 
			"Fizzy Madame", 
			"Cream Candycane", 
			"Chocolatey Neon", 
			"Jingle Dollie", 
			"Tinker Angel", 
			"Silhouette Hunnie", 
			"Goofy Carot", 
			"Funny Doc", 
			"Precious Pinkest", 
			"Sweetie Sweety", 
			"Chickie Magic", 
			"Miss Candied", 
			"Cryztal Blondie", 
			"Candy Salt", 
			"Diamond Guardian", 
			"Frog Light", 
			"Lolly Bling", 
			"Grizzly Turkey", 
			"Kookie Poochie", 
			"Chewy Muffin", 
			"Babycake Ballerina", 
			"Dixie Doodles", 
			"Twinkling Melody"};
	

	@OnOpen
	public void open(Session session) {
		System.out.println("Connection made!");
		Pair<Session, String> p = new Pair<Session, String>(session,"");
		sessionVector.add(p);
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		String screenName = "";
		String[] messageArray = message.replace("%20", " ").split(",");
		if(messageArray.length < 0) {
			return;
		}
		
		if(messageArray[0].equals("Login")) {
			dob.setFullname(messageArray[1]);
			dob.setEmail(messageArray[2]);
			for(int i = 0; i < sessionVector.size(); i++) {
				if(sessionVector.get(i).getKey().equals(session)) {
					Pair<Session, String> p = new Pair<Session, String>(session,messageArray[2]);
					sessionVector.set(i, p);
				}
			}
			screenName = logUserIn(messageArray[2], messageArray[1]);
			for(int i = 0; i < sessionVector.size(); i++) {
				sendHTML();
			}
		} else if(messageArray[0].equals("Logout")) {
			dob.setFullname(messageArray[1]);
			dob.setEmail(messageArray[2]);
			logUserOut(messageArray[2]);
		} else if(messageArray[0].equals("Song")) {
			addSong(messageArray[1], messageArray[2]);
		} else if(messageArray[0].equals("SendingSong")) {
			String takeSongSN = messageArray[1];
			String giveSongSN = messageArray[2];
			System.out.println("username we are taking from: " + takeSongSN);
			System.out.println("username we are sending back to: " + giveSongSN);
			songStatement(takeSongSN,giveSongSN);
		}

	}

	@OnClose
	public void close(Session session) {
		JDBCDriver.close();
		for(int i = 0; i < sessionVector.size(); i++) {
			if(sessionVector.get(i).getKey().equals(session)) {
				logUserOut(sessionVector.get(i).getValue());
				sessionVector.remove(i);
			}
		}
		for(int i = 0; i < sessionVector.size(); i++) {
			sendHTML();
		}
		System.out.println("User left: " + sessionVector.size());
	}

	@OnError
	public void error(Throwable error) {
		System.out.println("Error! " + error);
		error.printStackTrace();
	}

	public synchronized String logUserIn(String email, String fullName) { //might want to make this synchronized
		JDBCDriver.connect();
		String screenName = "";
		try {
			JDBCDriver.ps = JDBCDriver.conn.prepareStatement("SELECT screenName FROM Users WHERE email=?");
			JDBCDriver.ps.setString(1, email);
			JDBCDriver.rs = JDBCDriver.ps.executeQuery();
			if(JDBCDriver.rs.next()) {
				//user exists
				//pull screen name, set active to true
				screenName = JDBCDriver.rs.getString("screenName");
				JDBCDriver.ps = JDBCDriver.conn.prepareStatement("UPDATE Users SET active=true WHERE email=?");
				JDBCDriver.ps.setString(1, email);
				JDBCDriver.ps.execute();
			} else {
				//user doesn't exist
				//Random rand = new Random();
				//int index = rand.nextInt(188); //generate a number between 0 and 187
				int nameNum = totalUsers();
				screenName = screenNames[nameNum];
				JDBCDriver.connect();
				System.out.println("Screen name: " + screenName); //DEBUG
				JDBCDriver.ps = JDBCDriver.conn.prepareStatement("INSERT INTO Users (email, fullName, screenName, song, active) VALUES (?, ?, ?, '', true);");
				JDBCDriver.ps.setString(1, email);
				JDBCDriver.ps.setString(2, fullName);
				JDBCDriver.ps.setString(3, screenName);
				JDBCDriver.ps.execute();
			}
		} catch(SQLException sqle) {
			System.out.println("SQLException thrown in user login: " + sqle.getMessage());
		} finally {
			try {
				if (JDBCDriver.rs != null) {
					JDBCDriver.rs.close();
				}
				if (JDBCDriver.ps != null) {
					JDBCDriver.ps.close();
				}
				if (JDBCDriver.conn != null) {
					JDBCDriver.conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle user login: " + sqle.getMessage());
			}
		}
		return screenName;
	}

	public synchronized void logUserOut(String email) {
		JDBCDriver.connect();
		try {
			JDBCDriver.ps = JDBCDriver.conn.prepareStatement("UPDATE Users SET active=false WHERE email=?");
			JDBCDriver.ps.setString(1, email);
			JDBCDriver.ps.execute();
		} catch(SQLException sqle) {
			System.out.println("SQLException thrown in user login: " + sqle.getMessage());
		} finally {
			try {
				if (JDBCDriver.rs != null) {
					JDBCDriver.rs.close();
				}
				if (JDBCDriver.ps != null) {
					JDBCDriver.ps.close();
				}
				if (JDBCDriver.conn != null) {
					JDBCDriver.conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle user login: " + sqle.getMessage());
			}
		}
	}
    //Creates HTML string of HTML users

    public synchronized String createHTML(String email, String screenName) {
    	String sampleHTML = "<div class=\"row d-flex justify-content-center\">\n" + 
    			"		<!-- image of most used rapper -->\n" + 
    			"		<div class='w-100 d-flex justify-content-center'>\n" + 
    			"				<img src=\"src/pitbull.png\" id=\"mostusedrapper\"> \n" + 
    			"		</div>\n" + 
    			"		\n" + 
    			"		<!-- randomly generated screen name -->\n" + 
    			"		<div class=\"justify-content-center\" id=\"screen-name\">\n" + 
    			screenName + 
    			"		</div>\n" + 
    			"	</div> ";
    	
    	sampleHTML += "	<div class=\"row justify-content-center\" id=\"friends\">	\n" + 
    			"		<!-- active users text -->		\n" + 
    			" 		<img src=\"src/activeusers.png\" id=\"activeuserstext\">\n" + 
    			"		<div class=\"side w-100\" id=\"activetable\">\n" +
    			"<ul class=\"w-100\">\n";
    	
    	JDBCDriver.connect();
    	try 
		{
			JDBCDriver.ps =  JDBCDriver.conn.prepareStatement("SELECT * FROM Users");
			JDBCDriver.rs = JDBCDriver.ps.executeQuery();
			String status = "";
			
			while(JDBCDriver.rs.next()) {
				if(!JDBCDriver.rs.getString("email").equals(email)) {
					String songSender = "";
					if(JDBCDriver.rs.getString("active").equals("1")) {
						status = "<img src=\"src/online.png\">\n";
						System.out.println(JDBCDriver.rs.getString("email") + " is online.");
						songSender = "onClick=\"sendSong('" + JDBCDriver.rs.getString("screenName") + "','" + screenName + "');\"";
					}
					else {
						status = "<img src=\"src/offline2.png\">\n";
						System.out.println(JDBCDriver.rs.getString("email") + " is offline.");
					}
					sampleHTML += "				<li class=\"user w-100\">\n" + 
	        				status + 
	        				"					<span class=\"ml-1 username\"" + songSender + "> " + JDBCDriver.rs.getString("screenName") + " </span>\n" + 
	        				"				</li>";
				}
			} 
			
			
		} 
		catch (SQLException e) 
		{
			System.out.println("sqle in song addition: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCDriver.close();
		}

    	sampleHTML += "</ul>\n" + 
    			"		</div>	</div>";
 
    	sampleHTML += "<!-- logout text -->\n" + 
    			"	<div class=\"row justify-content-center\">\n" + 
    			"	 	<input class=\"g-signin2\" id=\"signOutButton\" style=\"max-height: 100px; max-width: 150px;\" type=\"image\" src=\"src/logout.png\" />\n" + 
    			"	</div>\n" + 
    			"\n" + 
    			"	<!-- asap logout image -->\n" + 
    			" 	<img class=\"rounded-circle\" id=\"lilasap\" src=\"src/asapstanding.png\">	";
    	return sampleHTML;
    }
    
    public synchronized void addSong(String song, String email) {
    	JDBCDriver.connect();
		try 
		{
			JDBCDriver.ps =  JDBCDriver.conn.prepareStatement("UPDATE Users SET song=? WHERE email=?");
			JDBCDriver.ps.setString(1, song);
			JDBCDriver.ps.setString(2, email);
			JDBCDriver.ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println("sqle in song addition: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCDriver.close();
		}
    }
    
    public synchronized void sendHTML() {
		for(int i = 0; i < sessionVector.size(); i++) {
			JDBCDriver.connect();
			try {
				JDBCDriver.ps = JDBCDriver.conn.prepareStatement("SELECT screenName FROM Users WHERE email=?");
				JDBCDriver.ps.setString(1, sessionVector.get(i).getValue());
				JDBCDriver.rs = JDBCDriver.ps.executeQuery();
				if(JDBCDriver.rs.next()) {
					dob.setScreename(JDBCDriver.rs.getString("screenName"));
					}
				sessionVector.get(i).getKey().getBasicRemote().sendText(createHTML(sessionVector.get(i).getValue(), dob.getScreename()));
			} catch (IOException ioe) {
				System.out.println("ioe: " + ioe.getMessage());
			} catch (SQLException sqle) {
				System.out.println("sqle html send: " + sqle.getMessage());
			} finally {
				JDBCDriver.close();
			}
		} 
    }
    
    public int totalUsers() {
    	int i = 0;
    	JDBCDriver.connect();
    	try {
        	JDBCDriver.ps = JDBCDriver.conn.prepareStatement("SELECT * FROM Users");
        	JDBCDriver.rs = JDBCDriver.ps.executeQuery();
        	while(JDBCDriver.rs.next()) {
        		i++;
        	}
    	} catch (SQLException sqle) {
			System.out.println("sqle html send: " + sqle.getMessage());
		} finally {
			JDBCDriver.close();
		}
    	System.out.println("Reached this point with " + i + "users.");
    	return i;
    }
    
    public synchronized void songStatement(String takeSongSN, String giveSongSN) {
		JDBCDriver.connect();
		String song = "";
		String email = "";
		try {
			JDBCDriver.ps = JDBCDriver.conn.prepareStatement("SELECT song FROM Users WHERE screenName=?");
			JDBCDriver.ps.setString(1, takeSongSN);
			JDBCDriver.rs = JDBCDriver.ps.executeQuery();
			if(JDBCDriver.rs.next()) {
				song = JDBCDriver.rs.getString("song");
			}
			JDBCDriver.ps = JDBCDriver.conn.prepareStatement("SELECT email FROM Users WHERE screenName=?");
			JDBCDriver.ps.setString(1, giveSongSN);
			JDBCDriver.rs = JDBCDriver.ps.executeQuery();
			if(JDBCDriver.rs.next()) {
				email = JDBCDriver.rs.getString("email");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle html send: " + sqle.getMessage());
		} finally {
			JDBCDriver.close();
		}
		for(int i = 0; i < sessionVector.size(); i++) {
			if(sessionVector.get(i).getValue().equals(email)) {
				try {
					sessionVector.get(i).getKey().getBasicRemote().sendText("b" + song);
				} catch(IOException ioe) {
					System.out.println("ioe in sending song back: " + ioe.getMessage());
					ioe.printStackTrace();
				}
				
			}
		}
    }

}