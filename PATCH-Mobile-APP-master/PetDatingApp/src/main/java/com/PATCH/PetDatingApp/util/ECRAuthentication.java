package com.PATCH.PetDatingApp.util;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ecr.AmazonECR;
import com.amazonaws.services.ecr.AmazonECRClientBuilder;
import com.amazonaws.services.ecr.model.GetAuthorizationTokenRequest;
import com.amazonaws.services.ecr.model.GetAuthorizationTokenResult;

import java.io.PrintStream;
import java.util.Base64;

public class ECRAuthentication {
    public static void main(String[] args) {
    AWSCredentials credentials = new BasicAWSCredentials("AKIA5UDPTKZJ5VSNHD7Q", "42j8RSE5fkqmODoK2aUyqCqccSfSZjWly6TTNgTy");

    AmazonECR ecrClient = AmazonECRClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion("us-east-1")
            .build();


        GetAuthorizationTokenRequest tokenRequest = new GetAuthorizationTokenRequest();
        // Get authorization token
        GetAuthorizationTokenResult authResult = ecrClient.getAuthorizationToken(tokenRequest);

        // Extract authorization token
        String authorizationToken = authResult.getAuthorizationData()
                .get(0)
                .getAuthorizationToken();

        // Print authorization token
        PrintStream out = System.out;
        out.print("ECR Auth Token: ");
        out.println(authorizationToken);

    }
    public static String getECRAuthorizationToken() {
        AWSCredentials credentials = new BasicAWSCredentials("AKIA5UDPTKZJ5VSNHD7Q", "42j8RSE5fkqmODoK2aUyqCqccSfSZjWly6TTNgTy");

        AmazonECR ecrClient = AmazonECRClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion("us-east-1")
                .build();

        GetAuthorizationTokenRequest tokenRequest = new GetAuthorizationTokenRequest();
        // Get authorization token
        GetAuthorizationTokenResult authResult = ecrClient.getAuthorizationToken(tokenRequest);

        // Extract authorization token
        String authorizationToken = authResult.getAuthorizationData()
                .get(0)
                .getAuthorizationToken();

        // Decode the base64-encoded token
        byte[] decodedToken = Base64.getDecoder().decode(authorizationToken);
        return new String(decodedToken);
    }
}
