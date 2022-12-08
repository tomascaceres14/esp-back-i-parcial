
db = db.getSiblingDB('series-dev-mongo');

db.createUser({
  user: "user-series-mongo",
  pwd: "pwd-series-mongo",
  roles: [
    {
      role: "readWrite",
      db: "series-dev-mongo",
    },
  ],
});

db.createCollection('Serie');

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
        urlStream: "www.mundialqatar2022.tv",
      },
    },
  },
]);