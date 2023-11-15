package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.configuration.JwtConfig;
import com.PATCH.PetDatingApp.dto.LoginRequest;
import com.PATCH.PetDatingApp.dto.RegisterRequest;
import com.PATCH.PetDatingApp.model.MarkedForum;
import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.model.Pet;
import com.PATCH.PetDatingApp.repository.UserRepository;
import com.PATCH.PetDatingApp.repository.PetRepository;
import com.PATCH.PetDatingApp.repository.MarkedForumRepository;
import com.google.firebase.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());
    private static final long EXPIRATION_TIME_MS = 30 * 60 * 1000; // 30 minutes
//    private static final String SECRET_KEY = "MmEwN2JiYTYyMThhNDhiMDM4ZjRkYTVlZjIxNGU5N2Y0NzhmMjFhNDE1NWQ2MDJiZjZlY2QxM2JkMGE2YmIwMQ==";


    @Autowired
    private PetRepository petRepository;
    @Autowired
    private MarkedForumRepository markedForumRepository;
    @Autowired
    private JwtConfig jwtConfig;



    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder; // Add this field for password encoder


//    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtConfig jwtConfig /* other dependencies */) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        // Initialize other dependencies...
//        this.jwtSecretKey = jwtConfig.getSecretKey();
//    }


    private final ImageUploadService imageUploadService;
//    @Autowired
//    private final RegisterRequest registerRequest;
    private final FirebaseAuth firebaseAuth; // Add this line



    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, ImageUploadService imageUploadService /*RegisterRequest registerRequest*/, FirebaseAuth firebaseAuth){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.imageUploadService = imageUploadService;
//        this.registerRequest = registerRequest;
        this.firebaseAuth = firebaseAuth;

    }
//    private String generateJwtToken(User user) {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME_MS);
//        return Jwts.builder()
//                .setSubject(user.getId()) // Use user ID as the subject (sub) of the token
//                .setIssuedAt(now)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecretKey().getBytes()) // Use the jwtSecretKey from JwtConfig
//                .compact();
//    }


    /*@Autowired
    private EmailService emailService;*/

//    @Override
//    public User register(User user) {
//        return userRepository.save(user);
//    }
//@Override
//public User registerUser(User user) {
//    // Check if the provided email or username already exists in the database
//    if (userRepository.existsByEmail(user.getEmail())) {
//        throw new IllegalArgumentException("Email already in use");
//    }
//    if (userRepository.existsByUsername(user.getUsername())) {
//        throw new IllegalArgumentException("Username already in use");
//    }
//
//    // Encrypt the user's password before saving it to the database
//    user.setPassword(hashPassword(user.getPassword()));
//
//    // Save the user to the database
//    return userRepository.save(user);
//}

//    @Override
//    public User registerUser(User user) {
//        // Check if the provided email or username already exists in the database
//        if (userRepository.existsByEmail(user.getEmail())) {
//            throw new IllegalArgumentException("Email already in use");
//        }
//        if (userRepository.existsByUsername(user.getUsername())) {
//            throw new IllegalArgumentException("Username already in use");
//        }
//
//        // Encrypt the user's password before saving it to the database
//        String trimmedPassword = user.getPassword().trim();
//        user.setPassword(hashPassword(trimmedPassword));
//
//        // Save the user to the database
//        return userRepository.save(user);
//    }

    // Other user-related methods

    //    private String hashPassword(String password) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder.encode(password);
//    }
//
    private String hashPassword(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }


    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

//    @Override
//    public boolean existsByUsername(String username) {
//        return userRepository.existsByUsername(username);
//    }

//    @Override
//    public String uploadImage(String pid, MultipartFile file) throws IOException {
//        // Retrieve the Pet from the database
//        Pet pet = petRepository.findByPid(pid);
//        if (pet == null) {
//            throw new EntityNotFoundException("Pet not found with PID: " + pid);
//        }
//
//        // Upload the image to Firebase Storage and get the image URL
//        String imageUrl = imageUploadService.uploadImage(file, "pets/" + pid + "/" + file.getOriginalFilename());
//
//        // Save the image URL to the Pet entity
//        pet.setImageUrl(imageUrl);
//        petRepository.save(pet);
//
//        return imageUrl;
//    }

//    @Override
//    public String getPetImageData(String pid) {
//        // Retrieve the Pet from the database
//        Pet pet = petRepository.findByPid(pid);
//        if (pet == null) {
//            throw new EntityNotFoundException("Pet not found with PID: " + pid);
//        }
//
//        // Retrieve the Base64-encoded image data from the Pet entity
//        return pet.getImageData();
//    }
    //@Override
//public User login(String usernameOrEmail, String password) {
//    // Find the user by username or email
//    User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
//    logger.info("Attempting login for username/email: {}", usernameOrEmail);
//    System.out.println("usernameOrEmail: " + usernameOrEmail);
//    System.out.println("Input password: " + password);
//
//
//    System.out.println("user: " + user);
//    System.out.println("Stored hashed password: " + user.getPassword());
//
//    // If the user is not found or the password is incorrect, throw an exception
//    if (user == null || !isPasswordValid(password, user.getPassword())) {
//        logger.warn("Invalid username/email or password for user: {}", usernameOrEmail);
//        throw new IllegalArgumentException("Invalid username/email or password");
//    }
//
//    // Generate JWT token
//    String jwtToken = generateJwtToken(user, jwtConfig.getSecretKey());
//    logger.info("JWT Token generated for user: {}", usernameOrEmail);
//
//    // Set the JWT token to the user
//    user.setJwtToken(jwtToken);
//    logger.info("JWT Token set for user: {}", usernameOrEmail);
//
//
//    return user;
//}
//@Override
//public User login(String usernameOrEmail, String password) {
//    // Find the user by username or email
//    password = password.trim();
//    User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
//    logger.info("Attempting login for username/email: " + usernameOrEmail);
//    logger.info("usernameOrEmail: " + usernameOrEmail);
//    logger.info("Input password: " + password);
//
//    if (user == null) {
//        logger.warn("User not found with username/email: " + usernameOrEmail);
//        throw new IllegalArgumentException("Invalid username/email or password");
//    }
//
//    logger.info("user: " + user);
//    logger.info("Stored hashed password: " + user.getPassword());
//
//    // If the user is not found or the password is incorrect, throw an exception
//    if (!isPasswordValid(password, user.getPassword())) {
//        logger.warn("Invalid password for user: " + usernameOrEmail);
//        throw new IllegalArgumentException("Invalid username/email or password");
//    }
//
//    // Generate JWT token
//    String jwtToken = generateJwtToken(user, jwtConfig.getSecretKey());
//
//    // Set the JWT token to the user
//    user.setJwtToken(jwtToken);
//
//    return user;
//
//}
//    private boolean isPasswordValid(String rawPassword, String hashedPassword) {
//        System.out.println("Raw password: " + rawPassword);
//        System.out.println("Hashed password: " + hashedPassword);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder.matches(rawPassword, hashedPassword);
//    }
    private boolean isPasswordValid(String rawPassword, String hashedPassword) {
        logger.info("Raw password: " + rawPassword);
        logger.info("Hashed password: " + hashedPassword);
        System.out.println("Raw password length: " + rawPassword.length());
        System.out.println("Hashed password length: " + hashedPassword.length());
        return passwordEncoder.matches(rawPassword, hashedPassword);

    }

//    public String generateToken(User user) {
//        return generateJwtToken(user, jwtConfig.getSecretKey());
//    }
//public String generateToken(User user, JwtConfig jwtConfig) {
//    return generateJwtToken(user, jwtConfig.getSecretKey());
//}
//
//
//    // Helper method to generate JWT token
//    private String generateJwtToken(User user, String secretKey) {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME_MS); // Define your token expiration time, e.g., 30 minutes
//
//        // Create the JWT token with user information
//
//        String compactJwt = Jwts.builder()
//                .setSubject("test")
//                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS512)
//                .compact();
//        return compactJwt;
//        return Jwts.builder()
//                .setSubject(user.getId()) // Use user ID as the subject (sub) of the token
//                .setIssuedAt(now)
//                .setExpiration(expirationDate)
//                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS512)
//                .compact();
////        String compactJwt = Jwts.builder()
////                .setSubject("test")
////                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS512)
////                .compact();
////        return compactJwt;





//    @Override
//    public void resetPassword(EmailRequest request) {
//        // Logic to reset user's password
//    }

    @Override
    public User getUser(String uid) {
        User user = userRepository.findByUid(uid);
        List<MarkedForum> markedForums = markedForumRepository.findByUid(uid);
        List<User> users = (List<User>) userRepository.findAll();


        List<MarkedForum> filteredLikedForums = markedForums.stream()
                .filter(markedForum -> markedForum.getUid().equals(user.getUid()) && !markedForum.isSavedForum())
                .collect(Collectors.toList());

        List<MarkedForum> filteredSavedForums = markedForums.stream()
                .filter(markedForum -> markedForum.getUid().equals(user.getUid()) && markedForum.isSavedForum())
                .collect(Collectors.toList());

        user.setLikedForums(filteredLikedForums);
        user.setSavedForums(filteredSavedForums);

        /*logger.info("user : " + user.toString() + " markedForums: " + markedForums.toString());*/
        return user;


    }


    @Override
    public List<User> getAllUser() {
//        List<MarkedForum> markedForums = markedForumRepository.findByUid(id);
        List<User> users = (List<User>) userRepository.findAll();
//        for (User user : users) {
//            user.setLikedForums(markedForums);
//        }

        logger.info("markedForums:2 " + users);
        return users;

        /*return (List<User>) userRepository.findAll();
         */
    }


    @Override
    public User updateUser(User user) {
        User prevUser = userRepository.findByUid(user.getUid());
        if (user.getName() != null) {
            prevUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            prevUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            prevUser.setPassword(user.getPassword());
        }

        logger.info("User Update: " + prevUser.toString());
        return userRepository.save(prevUser);
    }


    @Override
    public List<Pet> getUserPets(String uid) {
        logger.info("User Pets : " + petRepository.findByUid(uid));
        return petRepository.findByUid(uid);
    }

//    @Override
//    public Pet getPet(String pid) {
//        logger.info("Pet : " + pid + petRepository.findByPid(pid));
//        return petRepository.findByPid(pid);
//    }
//
//    @Override
//    public Pet createPet(Pet pet) {
//        logger.info("Pet Created : " + pet.toString());
//        return petRepository.save(pet);
//    }
//
//    @Override
//    public Pet updatePet(Pet pet) {
//        Pet prevPet = petRepository.findByPid(pet.getPid());
//        if (prevPet != null) {
//            if (pet.getName() != null) {
//                prevPet.setName(pet.getName());
//            }
//            if (pet.getType() != null) {
//                prevPet.setType(pet.getType());
//            }
//            if (pet.getBreed() != null) {
//                prevPet.setBreed(pet.getBreed());
//            }
//            if (pet.getColors() != null) {
//                prevPet.setColors(pet.getColors());
//            }
//            if (pet.getGender() != null) {
//                prevPet.setGender(pet.getGender());
//            }
//            if (pet.getWeight() != 0.0) {
//                prevPet.setWeight(pet.getWeight());
//            }
//            if (pet.getAge() != 0) {
//                prevPet.setAge(pet.getAge());
//            }
//            if (pet.getVaccineStatus() != null) {
//                prevPet.setVaccineStatus(pet.getVaccineStatus());
//            }
//            if (pet.getCharacter1() != null) {
//                prevPet.setCharacter1(pet.getCharacter1());
//            }
//            if (pet.getCharacter2() != null) {
//                prevPet.setCharacter2(pet.getCharacter2());
//            }
//            if (pet.getCharacter3() != null) {
//                prevPet.setCharacter3(pet.getCharacter3());
//            }
//            if (pet.getLike1() != null) {
//                prevPet.setLike1(pet.getLike1());
//            }
//            if (pet.getLike2() != null) {
//                prevPet.setLike2(pet.getLike2());
//            }
//            if (pet.getDislike1() != null) {
//                prevPet.setDislike1(pet.getDislike1());
//            }
//            if (pet.getDislike2() != null) {
//                prevPet.setDislike2(pet.getDislike2());
//            }
//            if (pet.getLongitude() != 0.0) {
//                prevPet.setLongitude(pet.getLongitude());
//            }
//            if (pet.getLatitude() != 0.0) {
//                prevPet.setLatitude(pet.getLatitude());
//            }
//
//            logger.info("Pet Update: " + prevPet.toString());
//            return petRepository.save(prevPet);
//        } else {
//            // Handle the case when prevPet is null
//            // For example, you can throw an exception or return a default response
//            throw new IllegalArgumentException("Pet not found with ID: " + pet.getPid());
//        }
//
//
//    }

    @Override
    public boolean deleteUser(String uid) {
        User user = userRepository.findByUid(uid);
        if (user != null) {
            userRepository.delete(user);
            logger.info("Deleted User: " + deleteUser(uid));
            return true;
        } else {
            logger.warn("Could not find User with ID {} to delete.", uid);
            return false;
        }
    }

//    @Override
//    public boolean deletePet(String pid) {
//        Pet pet = petRepository.findByPid(pid);
//        if (pet != null) {
//            petRepository.delete(pet);
//            logger.info("Deleted pet: " + deletePet(pid));
//            return true;
//        } else {
//            logger.warn("Could not find Pet with ID {} to delete.", pid);
//            return false;
//        }
//    }

    @Override
    public List<Pet> getPetsByUser(String uid) {
        return petRepository.findByUid(uid);
    }


    @Override
    public Pet createPetForUser(String uid, Pet pet) {
        // Find the user by ID
        User user = userRepository.findByUid(uid);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + uid);
        }

        // Set the user ID for the pet
        pet.setUid(uid);

        // Save the pet
        Pet createdPet = petRepository.save(pet);

        // Add the pet to the user's pet list
        List<Pet> userPets = user.getPets();
        userPets.add(createdPet);
        user.setPets(userPets);
        userRepository.save(user);

        logger.info("Created pet for user: " + createdPet.toString());

        return createdPet;
    }


    @Override
    public User findByUserUid(String uid) {
        return userRepository.findByUid(uid);
    }

    @Override
    public User findByUid(String uid) {
        return userRepository.findByUid(uid);
    }

//    @Override
//    public User login(String usernameOrEmail, String password, String rawPassword, String encodedPassword) {
//        password = password.trim();
//
//        logger.info("Attempting login for username/email: " + usernameOrEmail);
//        logger.info("Raw password: " + password);
//
//        try {
//            // Find the user by username or email
//            User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
//            logger.info("user: " + user);
//            logger.info("Input password: " + password);
//            logger.info("Stored hashed password: " + user.getPassword());
//
//            // If the user is not found or the password is incorrect, throw an exception
//            if (user == null || (!passwordEncoder.matches(rawPassword, encodedPassword))) {
//                logger.warn("Invalid username/email or password for user: " + usernameOrEmail);
//                throw new IllegalArgumentException("Invalid username/email or password");
//
//            }
//
//            // Generate JWT token
//
//            String jwtToken = generateJwtToken(user, jwtConfig.getSecretKey());
//            logger.info("JWT Token generated for user: " + usernameOrEmail);
//
//            // Set the JWT token to the user
//            user.setJwtToken(jwtToken);
//
//            return user;
//        } catch (Exception e) {
//            logger.error("Error during login: " + e.getMessage());
//            throw e; // Rethrow the exception to be handled by the controller
//        }
//    }
//@Override
//public User login(String username, String password) {
//
//    // Trim password
//    password = password.trim();
//    // Get raw password from login request
//    String rawPassword = password;
//
//    // Find user by username
//    User user = userRepository.findByUsername(username);
//    // Get encoded password from user
//    String encodedPassword = user.getPassword();
//
//    // Log hashed password from DB
//    logger.info("Encoded password from DB: " + user.getPassword());
//
//    // Check password match
//    boolean isMatch = passwordEncoder.matches(password, user.getPassword());
//
//    if(!passwordEncoder.matches(rawPassword, user.getPassword())) {
//        try {
//            throw new Exception("Invalid credentials");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // Log if password matches
//    logger.info("Password match: " + isMatch);
//
//    // Generate JWT token
//    String token = generateToken(user);
//
//    // Set token on user
//    user.setJwtToken(token);
//
//    // Return user
//    return user;
//
//}


//    @Override
//    public User registerUser(User user) {
//
//        String rawPassword = user.getPassword();
//
//        // Trim password
//        rawPassword = rawPassword.trim();
//
//        // Encode password
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//
//
//        // Set encoded password on user
//        user.setPassword(encodedPassword);
//
//        // Save user
//        return userRepository.save(user);
//
//    }
//

//    // Register user
//    @Override
//    public User registerUser(String email, String password) {
//        if (existsByEmail(email)) {
//            // User with this email already exists
//            return null;
//        }
//
//        // Create a new user object
//        User newUser = new User();
//        newUser.setEmail(email);
//
//        // Hash the password and set it in the user object
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
//        newUser.setPassword(hashedPassword);
//
//        // Save the user to the database using your UserRepository implementation
//        // Example:
//         userRepository.save(newUser);
//
//        // Return the registered user
//        return newUser;
//    }

    //    @Override
//    public String login(String email, String password, String idToken) {
//        try {
//            // Authenticate the user using Firebase Admin SDK
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
//
//            // Get the user's email from the decoded token
//            String userEmail = decodedToken.getEmail();
//
//            // Fetch the user from the database using the email
//            User user = userRepository.findByEmail(userEmail);
//
//            // Validate user and generate the JWT token (same as before)
//            if (user != null) {
//                return generateJwtToken(user);
//            } else {
//                // User not found
//                return null;
//            }
//        } catch (FirebaseAuthException e) {
//            // Handle authentication exceptions (invalid ID token, etc.)
//            e.printStackTrace();
//            return null;
//        }
//@Override
//public String login(String email, String password, String idToken) {
//    try {
//        // Authenticate the user using Firebase Admin SDK
//        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
//
//        // Get the user's email from the decoded token
//        String userEmail = decodedToken.getEmail();
//
//        // Fetch the user from the database using the email
//        User user = userRepository.findByEmail(userEmail);
//
//        // Validate user
//        if (user != null && authenticateUser(email, password, user)) {
//            // User is authenticated, generate the JWT token
//            return generateJwtToken(user);
//        } else {
//            // User not found or authentication failed
//            return null;
//        }
//    } catch (FirebaseAuthException e) {
//        // Handle authentication exceptions (invalid ID token, etc.)
//        e.printStackTrace();
//        return null;
//    }
//}
//
//    private boolean authenticateUser(String email, String password, User user) {
//        // Perform your custom user authentication logic here
//        // For example, check if the email and password match the user's credentials
//        // You can use BCryptPasswordEncoder to compare the password hashes
//        return user.getEmail().equals(email) && passwordMatches(password, user.getPassword());
//    }
//
//    private boolean passwordMatches(String rawPassword, String encodedPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }
//    private String generateJwtToken(User user) {
//        // Create claims (information) for the JWT token
//        Claims claims = Jwts.claims().setSubject(user.getId()); // You can set other information as needed
//
//        // Set the expiration date for the token (e.g., 1 hour from now)
//        Date expirationDate = new Date(System.currentTimeMillis() + 3600000);
//
//        // Generate the JWT token
//        String token = Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecretKey().getBytes())// Replace "YOUR_SECRET_KEY" with your actual secret key for signing the token
//                .compact();
//
//        return token;
//    }

//ini bisa
//    public User register(String email, String password) {
//
//        // Check if email already exists
//        if(userRepository.existsByEmail(email)) {
//            throw new IllegalArgumentException("Email already exists");
//        }
//
//        // Encode password
//        String encodedPassword = passwordEncoder.encode(password);
//
//        // Create new user
//        User newUser = new User();
//        newUser.setEmail(email);
//        newUser.setPassword(encodedPassword);
//
//        // Save user
//        return userRepository.save(newUser);
//
//    }
//    public String login(String email, String password) {
//        logger.info("Login email received: {}", email);
//        // Find user by email
//        User user = userRepository.findByEmail(email)
//                .orElse(null);
//
//        if(user == null) {
//            logger.warn("User not found for email: {}", email);
//            throw new RuntimeException("Invalid email");
//        }
//
//        if(!passwordEncoder.matches(password, user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//        logger.info("Found user: {}", user);
//        logger.info("Comparing hashed passwords...");
//        // Return user
//        return user.getUid();
//
//    }

    ///inibisaaa
//@Override
//public String login(String email, String password) {
//    logger.info("Login email received: {}", email);
//    // Find user by email
//    User user = userRepository.findByEmail(email);
//    logger.warn("User not found for email: {}", email);
//
//    if (!passwordEncoder.matches(password, user.getPassword())) {
//        throw new RuntimeException("Invalid password for user with email: " + email);
//    }
//
//    logger.info("User successfully logged in: {}", user);
//    // Return user UID
//    return user.getUid();
//}

//    public String login(String email, String password) {
//        logger.info("Login email received: {}", email);
//
//        // Find user by email
//        User user = userRepository.findByEmail(email);
//
//        if(user == null) {
//            logger.warn("User not found for email: {}", email);
//            throw new RuntimeException("Invalid email");
//        }
//
//        if(!passwordEncoder.matches(password, user.getPassword())) {
//            logger.warn("Invalid password for email: {}", email);
//            throw new RuntimeException("Invalid password");
//        }
//
//        logger.info("Found user: {}", user);
//        logger.info("Comparing hashed passwords...");
//
//
//        // Return user
//        return ("Login Succesful ! Welcome : " + user.getEmail());
//
//    }
//    @Override
//    public String register(RegisterRequest request) {
//        // Check if the email is already registered
//        if (userRepository.existsByEmail(request.getEmail())) {
//            throw new RuntimeException("Email already registered.");
//        }
//
//        // Create a new user in Firebase Authentication
//        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest()
//                .setEmail(request.getEmail())
//                .setPassword(request.getPassword())
//                .setDisplayName(request.getName());
//
//        UserRecord userRecord;
//        try {
//            userRecord = firebaseAuth.createUser(createRequest);
//        } catch (FirebaseAuthException e) {
//            throw new RuntimeException("Error creating user in Firebase Authentication.");
//        }
//
//        // Save the user details in your database (e.g., MongoDB)
//        User user = new User();
//        user.setEmail(request.getEmail());
//        user.setName(request.getName());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        // Set other user properties as needed
//
//        userRepository.save(user);
//
//        // Send email verification link
//        try {
//            firebaseAuth.generateEmailVerificationLink(user.getEmail());
//            // You can send the link to the user's email using your own email service
//            // or use Firebase to send the verification email.
//        } catch (FirebaseAuthException e) {
//            throw new RuntimeException("Error generating email verification link.");
//        }
//
//        return user.getName();
//    }

    @Override
    public String register(RegisterRequest request) {
        // Check if the email is already registered
        if (userRepository.existsByEmail(request.getEmail())) {
            logger.warn("Email {} is already registered.", request.getEmail());
            throw new RuntimeException("Email already registered.");
        }

        // Create a new user in Firebase Authentication
        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest()
                .setEmail(request.getEmail())
                .setPassword(request.getPassword())
                .setDisplayName(request.getName())
                .setEmailVerified(false); // Set email verification to false

        try {
            UserRecord userRecord = firebaseAuth.createUser(createRequest);
        } catch (FirebaseAuthException e) {
            e.printStackTrace(); // print full stack trace
        }

        // Save the user details in your database (e.g., MongoDB)
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // Set other user properties as needed

        userRepository.save(user);
        try {
            firebaseAuth.generateEmailVerificationLink(user.getEmail());

        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }

        // Firebase will automatically send the email verification link to the user's email

        return user.getName();
    }

    @Override
    public void initiatePasswordReset(String email) {
        try {
            // Generate the password reset link (action URL)
            String resetLink = generatePasswordResetLink(email);

            // Send the reset link to the user via email or other means
            // Example: emailService.sendPasswordResetLink(email, resetLink);
        } catch (Exception e) {
            // Handle the exception or log the error if needed
            throw new RuntimeException("Failed to initiate password reset.");
        }
    }

    private String generatePasswordResetLink(String email) throws FirebaseAuthException {
        // Generate the password reset link using the Firebase Admin SDK
        String resetLink = firebaseAuth.generatePasswordResetLink(email);
        return resetLink;
    }
    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            logger.warn("User not found for email: {}", user.getEmail());
            throw new RuntimeException("Invalid email");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            logger.warn("Invalid password for email: {}", email);
            throw new RuntimeException("Invalid password");
        }

        logger.info("User successfully logged in: {}", user.getEmail());
        String jwtToken = generateJwtToken(user.getEmail());

        // Save the JWT token in the user object
        user.setJwtToken(jwtToken);
        userRepository.save(user);



        return generateJwtToken(user.getEmail());
    }

    private String generateJwtToken(String email) {
        // Calculate the expiration date (1 week from the current time)
        long expirationTimeInMillis = System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000);
        Date expirationDate = new Date(expirationTimeInMillis);

        // Log the expiration date before generating the token
        logger.info("Token expiration date: " + expirationDate);

        String jwtToken = Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecretKey())
                .compact();

        // Log the generated token before returning it
        logger.info("Generated JWT token: " + jwtToken);

        return jwtToken;
    }
    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

