package com.rse.vault;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Scanner;

public class VaultService{
    private String password;
    private boolean isOpen;

    public VaultService(String password) {
        this.password = password;
        this.isOpen = false;
    }

    public void openVault(String enteredPassword) {
        if (enteredPassword.equals(password)) {
            System.out.println("Vault opened successfully.");
            isOpen = true;
        } else {
            System.out.println("Incorrect password. Vault remains closed.");
            isOpen = false;
        }
    }

    public void closeVault() {
        isOpen = false;
        System.out.println("Vault closed.");
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String encryptData(byte[] data, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey key = generateSecretKey(secretKey);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public byte[] decryptData(String encryptedData, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey key = generateSecretKey(secretKey);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return decryptedBytes;//new String(decryptedBytes);
    }

    private SecretKey generateSecretKey(String secretKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), password.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), "AES");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VaultService vault = new VaultService("password123");
        System.out.print("Enter the password to open the vault: ");
        String enteredPassword = scanner.nextLine();

        vault.openVault(enteredPassword);

        if (vault.isOpen()) {
            // Vault is open, perform operations here...

            // Encrypt data
            try {
                System.out.print("Enter data to encrypt: ");
                String data = scanner.nextLine();
                System.out.print("Enter a secret key for encryption: ");
                String secretKey = scanner.nextLine();
                String encryptedData =null;// vault.encryptData(data, secretKey);
                System.out.println("Encrypted data: " + encryptedData);

                // Decrypt data
                System.out.print("Enter a secret key for decryption: ");
                secretKey = scanner.nextLine();
                String decryptedData = null;//vault.decryptData(encryptedData, secretKey);
                System.out.println("Decrypted data: " + decryptedData);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Close the vault when finished
            vault.closeVault();
        }

        scanner.close();
    }
}

