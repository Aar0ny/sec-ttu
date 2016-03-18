package ee.ut.narva.proj.api.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ee.ut.narva.proj.api.domain.Person;
import ee.ut.narva.proj.api.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.upperCase;

@RestController
public class PersonController {
    @Inject
    private PersonService personService;

    /**
     * @api {get} /api/tour/featured/category/:categoryName Find tours by category
     * @apiName FindFeaturedByCategory
     * @apiGroup FeaturedTours
     * @apiParam {String} categoryName Tour category name
     * @apiSuccess {List} featuredTour List of FeaturedTours
     */
    @RequestMapping(value = "/api/person/all", method = {RequestMethod.GET})
    public List<Person> findAll() {
        return personService.findAll();
    }

    /**
//     * @api {get} /api/tour/language/:language Find tours by language
//     * @apiName FindFeaturedByLanguage
//     * @apiGroup Tours
//     * @apiParam {String} language Tour language
//     * @apiSuccess {List} tour List of tours by language
//     */
//    @RequestMapping(value = "/api/tour/language/{language}", method = {RequestMethod.GET})
//    public List<Tour> findToursByLanguage(@PathVariable String language) {
//        final List<Tour> tours = tourService.findTourByLanguage(language);
//        return tours;
//    }
//
//    /**
//     * @api {get} /api/tour/capacity/:capacity Find tours by capacity
//     * @apiName findToursByCapacity
//     * @apiGroup Tours
//     * @apiParam {String} capacity Tour capacity
//     * @apiSuccess {List} tour List of tours by capacity
//     */
//    @RequestMapping(value = "/api/tour/capacity/{capacity}", method = {RequestMethod.GET})
//    public List<Tour> findToursByCapacity(@PathVariable int capacity) {
//        final List<Tour> tours = tourService.findToursByCapacityInPersons(capacity);
//        return tours;
//    }
//
//    /**
//     * @api {get} /api/tour/period/:from/:to Find tours in period from/to
//     * @apiName FindToursByPeriod
//     * @apiGroup Tours
//     * @apiParam {String} from Tour from
//     * @apiParam {String} to Tour to
//     * @apiSuccess {List} tour List of tours by from/to dates
//     */
//    @RequestMapping(value = "/api/tour/period/{from}/{to}", method = {RequestMethod.GET})
//    public List<Tour> findToursByPeriod(@PathVariable String from, @PathVariable String to) throws ParseException {
//        final LocalDate fromDate = LocalDate.parse(from);
//        final LocalDate toDate = LocalDate.parse(to);
//        return tourService.findToursByPeriod(fromDate, toDate);
//    }
//
//    /**
//     * @api {get} /api/tour/search/:capacity/:from/:to Find tours in period from/to with capacity
//     * @apiName FindToursByCapacityAndPeriod
//     * @apiGroup Tours
//     * @apiParam {String} from From date
//     * @apiParam {String} to To date
//     * @apiParam {String} capacity Tour capacity
//     * @apiSuccess {List} tour List of tours by from/to dates sorted by capacity
//     */
//    @RequestMapping(value = "/api/tour/search/{capacity}/{from}/{to}", method = {RequestMethod.GET})
//    public List<Tour> findToursByCapacityAndPeriod(@PathVariable Integer capacity, @PathVariable String from, @PathVariable String to) throws ParseException {
//        final LocalDate fromDate = LocalDate.parse(from);
//        final LocalDate toDate = LocalDate.parse(to);
//        return tourService.findToursByCapacityInPersonsAndPeriod(fromDate, toDate, capacity);
//    }
//
//    /**
//     * @api {get} /api/tour/featured/:latitude/:longitude/:distance/:language Find featured tours by Latitude and Longitude and Distance and Language
//     * @apiName FindToursByLatLngAndLanguage
//     * @apiGroup Tours
//     * @apiParam {String} latitude Latitude
//     * @apiParam {String} longitude Longitude
//     * @apiParam {String} distance Distance
//     * @apiParam {String} language Language
//     * @apiSuccess {List} tour List of tours by Latitude and Longitude and Distance and Language
//     */
//    @RequestMapping(value = "/api/tour/latlng/{lat}/{lng}/{distance}/{language}", method = {RequestMethod.GET})
//    public List<Tour> findToursByLatLngAndLanguage(@PathVariable double lat, @PathVariable double lng, @PathVariable double distance, @PathVariable String language) {
//        return tourService.findToursByLatLngAndLanguage(lat, lng, distance, 15, language);
//    }
//
//    /**
//     * @api {get} /api/tour/featured/:latitude/:longitude/:distance Find featured tours by Latitude and Longitude and Distance
//     * @apiName FindFeaturedToursByLatLng
//     * @apiGroup Tours
//     * @apiParam {String} latitude Latitude
//     * @apiParam {String} longitude Longitude
//     * @apiParam {String} distance Distance
//     * @apiSuccess {List} tour List of tours by Latitude and Longitude and Distance
//     */
//    @RequestMapping(value = "/api/tour/featured/{lat}/{lng}/{distance}", method = {RequestMethod.GET})
//    public List<Tour> findFeaturedToursByLatLng(@PathVariable double lat, @PathVariable double lng, @PathVariable double distance) {
//        final List<Tour> tours = tourService.findFeaturedToursByLatLng(lat, lng, distance, 9);
//        return tours;
//    }
//
//    /**
//     * @api {get} /api/tour/featured/:country/:language Find featured tours by country and language
//     * @apiName FindFeaturedByCountryAndLanguage
//     * @apiGroup Tours
//     * @apiParam {String} country Tour country
//     * @apiParam {String} language Tour language
//     * @apiSuccess {List} tour List of tours by country and language
//     */
//    @RequestMapping(value = "/api/tour/featured/{country}/{language}", method = {RequestMethod.GET})
//    public List<Tour> findFeaturedToursByCountry(@PathVariable String country, @PathVariable String language) {
//        final Optional<FeaturedToursLocation> featuredTourLocationOpt = FeaturedToursLocation.find(StringUtils.upperCase(country));
//        if (featuredTourLocationOpt.isPresent()) {
//            return tourService.findFeaturedToursByLocationAndLanguage(featuredTourLocationOpt.get().getLocation(), 3000, 9, language);
//        } else throw new IllegalArgumentException(String.format("Supplied userType %s is invalid", country));
//    }
//
//    private List<FeaturedTour> toFeaturedTours(final List<Tour> tours) {
//        return tours.stream().map(f -> new FeaturedTour(
//                f.getId(),
//                f.getCreatedDate(),
//                f.getDuration(),
//                f.getUpdatedDate())).collect(Collectors.toList());
//    }
//
//    /**
//     * @api {get} /api/tours Find all tours
//     * @apiName findAllTours
//     * @apiGroup Tours
//     * @apiSuccess {List} tour List of tours
//     */
//    @RequestMapping(value = "/api/tours", method = {RequestMethod.GET})
//    public List<SimpleTour> findAllTours() {
//        final List<Tour> allTours = tourService.findAllTours();
//        return allTours.stream().map(t -> new SimpleTour(
//                t.getId(),
//                t.getDuration(),
//                t.getCreatedDate(),
//                t.getUpdatedDate()
//        )).collect(Collectors.toList());
//    }
//
//    /**
//     * @api {get} /api/tour/language/:tourId Find tour by id
//     * @apiName findTour
//     * @apiGroup Tours
//     * @apiParam {String} id Tour id
//     * @apiSuccess {Tour} tour Single tour by id
//     */
//    @RequestMapping(value = "/api/tour/{tourId}", method = {RequestMethod.GET})
//    public Tour findTour(@PathVariable String tourId) {
//        return tourService.findTour(tourId);
//    }
//
//    /**
//     * @api {get} /api/tour/categories Find all tour categories
//     * @apiName FindAllTourCategories
//     * @apiGroup Tours
//     * @apiSuccess {List} SimpleTourCategory List of tour categories
//     */
//    @RequestMapping(value = "/api/tour/categories", method = {RequestMethod.GET})
//    public List<SimpleTourCategory> findAllTourCategories() {
//        final List<TourCategory> tourCategories = tourService.findAllTourCategories();
//        return tourCategories.stream()
//                .map(c -> new SimpleTourCategory(c.getDescription(), c.getId(), c.getCode(), c.getPicturePath()))
//                .collect(Collectors.toList());
//    }
//
//    /*
//     *
//     {
//         "id": null,
//         "capacityInPersons": 1,
//         "price": 10.00,
//         "locationName" :"moo",
//         "featured": "true",
//         "picturePath": "http://lorempixel.com/500/500/nature/",
//         "location": {
//            "longitude": 18.00,
//            "latitude": 12.00
//         },
//         "tourCategory": {
//            "id": "052d8bbb-d3e0-40de-afbe-4ded4fd61c9c"
//         }
//     }
//     */
//
//    /**
//     * @api {post} /api/tour/create Create single tour
//     * @apiName createTour
//     * @apiGroup Tours
//     * @apiParam {Object} TourDTO Tour entity to be created
//     */
//    @RequestMapping(value = "/api/tour/create", method = {RequestMethod.POST})
//    public TourDTO createTour(@RequestBody @Valid TourDTO tourDTO) {
//        return tourService.createTour(tourDTO);
//    }
//
//    /*
//    {
//        "id": "59dcedcd-b5d9-4011-8435-284bda83a0f3",
//        "capacityInPersons": 3,
//        "price": 10.00,
//        "locationName" :"moo",
//        "featured": "true",
//        "picturePath": "http://lorempixel.com/500/500/nature/",
//        "location": {
//            "longitude": 18.00,
//            "latitude": 12.00
//        },
//        "tourCategory": {
//            "id": "474acab9-a5d6-490f-9961-907d559f123f"
//        }
//    }
//    */
//
//    /**
//     * @api {post, put, patch} /api/tour/update Update single tour
//     * @apiName updateTour
//     * @apiGroup Tours
//     * @apiParam {Object} TourDTO Tour entity to be updated
//     */
//    @RequestMapping(value = "/api/tour/update", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
//    public TourDTO updateTour(@RequestBody @Valid TourDTO tourDTO) {
//        return tourService.updateTour(tourDTO);
//    }
//
//    /*
//        /api/tour/delete/59dcedcd-b5d9-4011-8435-284bda83a0f3
//    */
//
//    /**
//     * @api {post, delete} /api/tour/delete/:id Update single tour
//     * @apiName deleteTour
//     * @apiGroup Tours
//     * @apiParam {String} id Tour id to be deleted
//     */
//    @RequestMapping(value = "/api/tour/delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE})
//    public TourDTO deleteTour(@PathVariable String id) {
//        return tourService.deleteTour(id);
//    }
//
//    final class SimpleTour {
//        public String id;
//        @JsonSerialize(using = DurationSerializer.class)
//        public Duration duration;
//        @JsonSerialize(using = LocalDateTimeSerializer.class)
//        public LocalDateTime created;
//        @JsonSerialize(using = LocalDateTimeSerializer.class)
//        public LocalDateTime updated;
//
//        public SimpleTour(String id, Duration duration, LocalDateTime created, LocalDateTime updated) {
//            this.id = id;
//            this.duration = duration;
//            this.created = created;
//            this.updated = updated;
//        }
//    }
//
//    final class FeaturedTour {
//        public String id;
//        @JsonSerialize(using = DurationSerializer.class)
//        public Duration duration;
//        @JsonSerialize(using = LocalDateTimeSerializer.class)
//        public LocalDateTime created;
//        @JsonSerialize(using = LocalDateTimeSerializer.class)
//        public LocalDateTime updated;
//
//        public FeaturedTour(String id, LocalDateTime created, Duration duration, LocalDateTime updated) {
//            this.id = id;
//            this.created = created;
//            this.duration = duration;
//            this.updated = updated;
//        }
//    }
//
//    final class SimpleTourCategory {
//        public String id;
//        public String code;
//        public String description;
//        public String picturePath;
//
//        public SimpleTourCategory(String description, String id, String code, String picturePath) {
//            this.description = description;
//            this.id = id;
//            this.code = code;
//            this.picturePath = picturePath;
//        }
//    }
}
