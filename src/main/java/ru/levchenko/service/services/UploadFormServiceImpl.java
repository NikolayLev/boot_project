package ru.levchenko.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.UsersRepository;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadFormServiceImpl implements UploadFormService {


    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private UsersRepository usersRepository;




    @Override
    public void store(MultipartFile file, User user) {

        if(file!=null) {

            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()){
                uploadDir.mkdir();
                System.out.println("Создали папку");
            }

            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + filename;

            try {
                file.transferTo(new File(uploadPath+"/"+resultFileName));
                user.setUploadPhoto(resultFileName);
                usersRepository.save(user);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

  // @Override
  // public Stream<Path> loadAll() {
  //     try {
  //         return Files.walk(this.rootLocation, 1)
  //                 .filter(path -> !path.equals(this.rootLocation))
  //                 .map(this.rootLocation::relativize);
  //     }
  //     catch (IOException e) {
  //         throw new StorageException("Failed to read stored files", e);
  //     }

  // }

  // @Override
  // public Path load(String filename) {
  //     return rootLocation.resolve(filename);
  // }

  // @Override
  // public Resource loadAsResource(String filename) {
  //     try {
  //         Path file = load(filename);
  //         Resource resource = new UrlResource(file.toUri());
  //         if (resource.exists() || resource.isReadable()) {
  //             return resource;
  //         }
  //         else {
  //             throw new StorageFileNotFoundException(
  //                     "Could not read file: " + filename);

  //         }
  //     }
  //     catch (MalformedURLException e) {
  //         throw new StorageFileNotFoundException("Could not read file: " + filename, e);
  //     }
  // }


}
