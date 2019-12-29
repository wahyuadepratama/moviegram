package site.wahyu.moviegram.utils;

import java.util.ArrayList;

import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.data.remote.model.TVShow;

public class FakeDataDummy {

    public static ArrayList<FavoriteMovieEntity> generateDummyFavoriteMovies() {

        ArrayList<FavoriteMovieEntity> movies = new ArrayList<>();

        movies.add(new FavoriteMovieEntity(1,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-01-31"));
        movies.add(new FavoriteMovieEntity(2,
                "5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07"));
        movies.add(new FavoriteMovieEntity(3,
                "lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2019-10-24"));
        movies.add(new FavoriteMovieEntity(4,
                "hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Cold pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-07"));
        movies.add(new FavoriteMovieEntity(5,
                "v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21"));
        movies.add(new FavoriteMovieEntity(6,
                "fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-14"));
        movies.add(new FavoriteMovieEntity(7,
                "svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-16"));
        movies.add(new FavoriteMovieEntity(8,
                "xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-01-03"));
        movies.add(new FavoriteMovieEntity(9,
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25"));
        movies.add(new FavoriteMovieEntity(10,
                "6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "2018-10-20"));

        return movies;
    }

    public static ArrayList<FavoriteTVShowEntity> generateDummyFavoriteTVShow() {

        ArrayList<FavoriteTVShowEntity> tvshow = new ArrayList<>();

        tvshow.add(new FavoriteTVShowEntity(1,
                "lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "2019-01-16"));
        tvshow.add(new FavoriteTVShowEntity(2,
                "jnaimWkIVSD9IInmZPyLYarSvvc.jpg",
                "Batwoman",
                "Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.",
                "2018-04-25"));
        tvshow.add(new FavoriteTVShowEntity(3,
                "mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2018-10-20"));
        tvshow.add(new FavoriteTVShowEntity(4,
                "wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2018-11-21"));
        tvshow.add(new FavoriteTVShowEntity(5,
                "c1HESLx4JaBW0rsKO3yljuMGCMf.jpg",
                "Food Wars!: Shokugeki no Soma",
                "Yukihira Souma's dream is to become a full-time chef in his father's restaurant and surpass his father's culinary skill. But just as Yukihira graduates from middle schools his father, Yukihira Jouichirou, closes down the restaurant to cook in Europe. Although downtrodden, Souma's fighting spirit is rekindled by a challenge from Jouichirou which is to survive in an elite culinary school where only 10% of the students graduate. Can Souma survive?",
                "2018-12-07"));
        tvshow.add(new FavoriteTVShowEntity(6,
                "yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "2019-01-31"));
        tvshow.add(new FavoriteTVShowEntity(7,
                "47h1ReX6SSqwiTaz3kCC14f0vzt.jpg",
                "My Hero Academia",
                "In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.",
                "2019-10-24"));
        tvshow.add(new FavoriteTVShowEntity(8,
                "1yeVJox3rjo2jBKrrihIMj7uoS9.jpg",
                "Breaking Bad",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                "2018-11-14"));
        tvshow.add(new FavoriteTVShowEntity(9,
                "KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "2019-01-03"));
        tvshow.add(new FavoriteTVShowEntity(10,
                "6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "2019-02-07"));

        return tvshow;
    }

    public static ArrayList<Movie> generateDummyNowPlayingMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-01-31"));
        movies.add(new Movie(2,
                "5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07"));
        movies.add(new Movie(3,
                "lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2019-10-24"));
        movies.add(new Movie(4,
                "hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Cold pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-07"));
        movies.add(new Movie(5,
                "v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21"));
        movies.add(new Movie(6,
                "fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-14"));
        movies.add(new Movie(7,
                "svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-16"));
        movies.add(new Movie(8,
                "xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-01-03"));
        movies.add(new Movie(9,
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25"));
        movies.add(new Movie(10,
                "6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "2018-10-20"));

        return movies;
    }

    public static ArrayList<Movie> generateDummyUpcomingMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(11,
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25"));
        movies.add(new Movie(12,
                "6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "2018-10-20"));
        movies.add(new Movie(13,
                "5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07"));
        movies.add(new Movie(14,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-01-31"));
        movies.add(new Movie(15,
                "hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Cold pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-07"));
        movies.add(new Movie(16,
                "lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2019-10-24"));
        movies.add(new Movie(17,
                "v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21"));
        movies.add(new Movie(18,
                "svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-16"));
        movies.add(new Movie(19,
                "fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-14"));
        movies.add(new Movie(20,
                "xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-01-03"));

        return movies;
    }

    public static ArrayList<Movie> generateDummyTopRatedMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(21,
                "5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07"));
        movies.add(new Movie(22,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-01-31"));
        movies.add(new Movie(23,
                "hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Cold pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-07"));
        movies.add(new Movie(24,
                "lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2019-10-24"));
        movies.add(new Movie(25,
                "fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-14"));
        movies.add(new Movie(26,
                "v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21"));
        movies.add(new Movie(27,
                "xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-01-03"));
        movies.add(new Movie(28,
                "svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-16"));
        movies.add(new Movie(29,
                "6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "2018-10-20"));
        movies.add(new Movie(30,
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25"));

        return movies;
    }

    public static ArrayList<Movie> generateDummyDetailMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-01-31"));
        movies.add(new Movie(2,
                "5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07"));
        movies.add(new Movie(3,
                "lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2019-10-24"));
        movies.add(new Movie(4,
                "hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Cold pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-07"));
        movies.add(new Movie(5,
                "v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21"));
        movies.add(new Movie(6,
                "fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-14"));
        movies.add(new Movie(7,
                "svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-16"));
        movies.add(new Movie(8,
                "xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-01-03"));
        movies.add(new Movie(9,
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25"));
        movies.add(new Movie(10,
                "6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "2018-10-20"));
        movies.add(new Movie(11,
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25"));
        movies.add(new Movie(12,
                "6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "2018-10-20"));
        movies.add(new Movie(13,
                "5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07"));
        movies.add(new Movie(14,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-01-31"));
        movies.add(new Movie(15,
                "hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Cold pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-07"));
        movies.add(new Movie(16,
                "lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2019-10-24"));
        movies.add(new Movie(17,
                "v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21"));
        movies.add(new Movie(18,
                "svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-16"));
        movies.add(new Movie(19,
                "fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-14"));
        movies.add(new Movie(20,
                "xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-01-03"));
        movies.add(new Movie(21,
                "5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07"));
        movies.add(new Movie(22,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-01-31"));
        movies.add(new Movie(23,
                "hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Cold pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-07"));
        movies.add(new Movie(24,
                "lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2019-10-24"));
        movies.add(new Movie(25,
                "fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-14"));
        movies.add(new Movie(26,
                "v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21"));
        movies.add(new Movie(27,
                "xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-01-03"));
        movies.add(new Movie(28,
                "svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-16"));
        movies.add(new Movie(29,
                "6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "2018-10-20"));
        movies.add(new Movie(30,
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25"));

        return movies;
    }

    public static ArrayList<TVShow> generateDummyTVShow() {

        ArrayList<TVShow> tvshow = new ArrayList<>();

        tvshow.add(new TVShow(1,
                "lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "2019-01-16"));
        tvshow.add(new TVShow(2,
                "jnaimWkIVSD9IInmZPyLYarSvvc.jpg",
                "Batwoman",
                "Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.",
                "2018-04-25"));
        tvshow.add(new TVShow(3,
                "mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2018-10-20"));
        tvshow.add(new TVShow(4,
                "wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2018-11-21"));
        tvshow.add(new TVShow(5,
                "c1HESLx4JaBW0rsKO3yljuMGCMf.jpg",
                "Food Wars!: Shokugeki no Soma",
                "Yukihira Souma's dream is to become a full-time chef in his father's restaurant and surpass his father's culinary skill. But just as Yukihira graduates from middle schools his father, Yukihira Jouichirou, closes down the restaurant to cook in Europe. Although downtrodden, Souma's fighting spirit is rekindled by a challenge from Jouichirou which is to survive in an elite culinary school where only 10% of the students graduate. Can Souma survive?",
                "2018-12-07"));
        tvshow.add(new TVShow(6,
                "yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "2019-01-31"));
        tvshow.add(new TVShow(7,
                "47h1ReX6SSqwiTaz3kCC14f0vzt.jpg",
                "My Hero Academia",
                "In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.",
                "2019-10-24"));
        tvshow.add(new TVShow(8,
                "1yeVJox3rjo2jBKrrihIMj7uoS9.jpg",
                "Breaking Bad",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                "2018-11-14"));
        tvshow.add(new TVShow(9,
                "KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "2019-01-03"));
        tvshow.add(new TVShow(10,
                "6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "2019-02-07"));

        return tvshow;
    }

    public static ArrayList<TVShow> generateDummyDetailTVShow() {

        ArrayList<TVShow> tvshow = new ArrayList<>();

        tvshow.add(new TVShow(1,
                "lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "2019-01-16"));
        tvshow.add(new TVShow(2,
                "jnaimWkIVSD9IInmZPyLYarSvvc.jpg",
                "Batwoman",
                "Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.",
                "2018-04-25"));
        tvshow.add(new TVShow(3,
                "mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2018-10-20"));
        tvshow.add(new TVShow(4,
                "wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2018-11-21"));
        tvshow.add(new TVShow(5,
                "c1HESLx4JaBW0rsKO3yljuMGCMf.jpg",
                "Food Wars!: Shokugeki no Soma",
                "Yukihira Souma's dream is to become a full-time chef in his father's restaurant and surpass his father's culinary skill. But just as Yukihira graduates from middle schools his father, Yukihira Jouichirou, closes down the restaurant to cook in Europe. Although downtrodden, Souma's fighting spirit is rekindled by a challenge from Jouichirou which is to survive in an elite culinary school where only 10% of the students graduate. Can Souma survive?",
                "2018-12-07"));
        tvshow.add(new TVShow(6,
                "yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "2019-01-31"));
        tvshow.add(new TVShow(7,
                "47h1ReX6SSqwiTaz3kCC14f0vzt.jpg",
                "My Hero Academia",
                "In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.",
                "2019-10-24"));
        tvshow.add(new TVShow(8,
                "1yeVJox3rjo2jBKrrihIMj7uoS9.jpg",
                "Breaking Bad",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                "2018-11-14"));
        tvshow.add(new TVShow(9,
                "KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "2019-01-03"));
        tvshow.add(new TVShow(10,
                "6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "2019-02-07"));

        return tvshow;
    }
}
