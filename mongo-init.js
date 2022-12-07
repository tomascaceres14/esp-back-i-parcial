db.createUser({
  user: "usrspotifymongo",
  pwd: "pwdspotifymongo",
  roles: [
    {
      role: "readWrite",
      db: "spotifydevmongo",
    },
  ],
});

db.Serie.insertMany([
  {
    serieId: 1,
    name: false,
    genre: "Terror",
    seasons: {
      seasonId: 1,
      seasonNumber: 1,
      chapters: {
        chapterId: 1,
        name: "Adrian, un capo",
        urlStream: "www  mundialqatar2022  tv",
      },
    },
  },
]);