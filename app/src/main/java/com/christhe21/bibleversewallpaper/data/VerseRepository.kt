package com.christhe21.bibleversewallpaper.data

import java.util.Calendar

/**
 * Offline repository of inspiring Bible verses (KJV / public domain style).
 * Verses cycle based on day of year so the same day always shows the same verse.
 */
object VerseRepository {

    private val verses = listOf(
        Verse(
            "For God so loved the world, that he gave his only begotten Son, that whosoever believeth in him should not perish, but have everlasting life.",
            "John 3:16"
        ),
        Verse(
            "I can do all things through Christ which strengtheneth me.",
            "Philippians 4:13"
        ),
        Verse(
            "The Lord is my shepherd; I shall not want.",
            "Psalm 23:1"
        ),
        Verse(
            "Trust in the Lord with all thine heart; and lean not unto thine own understanding.",
            "Proverbs 3:5"
        ),
        Verse(
            "Be strong and of a good courage; be not afraid, neither be thou dismayed: for the Lord thy God is with thee whithersoever thou goest.",
            "Joshua 1:9"
        ),
        Verse(
            "And we know that all things work together for good to them that love God, to them who are the called according to his purpose.",
            "Romans 8:28"
        ),
        Verse(
            "Fear thou not; for I am with thee: be not dismayed; for I am thy God: I will strengthen thee; yea, I will help thee; yea, I will uphold thee with the right hand of my righteousness.",
            "Isaiah 41:10"
        ),
        Verse(
            "Come unto me, all ye that labour and are heavy laden, and I will give you rest.",
            "Matthew 11:28"
        ),
        Verse(
            "The Lord is my light and my salvation; whom shall I fear? the Lord is the strength of my life; of whom shall I be afraid?",
            "Psalm 27:1"
        ),
        Verse(
            "But they that wait upon the Lord shall renew their strength; they shall mount up with wings as eagles; they shall run, and not be weary; and they shall walk, and not faint.",
            "Isaiah 40:31"
        ),
        Verse(
            "In the beginning was the Word, and the Word was with God, and the Word was God.",
            "John 1:1"
        ),
        Verse(
            "Jesus said unto him, I am the way, the truth, and the life: no man cometh unto the Father, but by me.",
            "John 14:6"
        ),
        Verse(
            "For I know the thoughts that I think toward you, saith the Lord, thoughts of peace, and not of evil, to give you an expected end.",
            "Jeremiah 29:11"
        ),
        Verse(
            "Delight thyself also in the Lord; and he shall give thee the desires of thine heart.",
            "Psalm 37:4"
        ),
        Verse(
            "Casting all your care upon him; for he careth for you.",
            "1 Peter 5:7"
        ),
        Verse(
            "The Lord is nigh unto them that are of a broken heart; and saveth such as be of a contrite spirit.",
            "Psalm 34:18"
        ),
        Verse(
            "Yea, though I walk through the valley of the shadow of death, I will fear no evil: for thou art with me; thy rod and thy staff they comfort me.",
            "Psalm 23:4"
        ),
        Verse(
            "Be still, and know that I am God: I will be exalted among the heathen, I will be exalted in the earth.",
            "Psalm 46:10"
        ),
        Verse(
            "This is the day which the Lord hath made; we will rejoice and be glad in it.",
            "Psalm 118:24"
        ),
        Verse(
            "Let the words of my mouth, and the meditation of my heart, be acceptable in thy sight, O Lord, my strength, and my redeemer.",
            "Psalm 19:14"
        ),
        Verse(
            "Create in me a clean heart, O God; and renew a right spirit within me.",
            "Psalm 51:10"
        ),
        Verse(
            "Thy word is a lamp unto my feet, and a light unto my path.",
            "Psalm 119:105"
        ),
        Verse(
            "O give thanks unto the Lord; for he is good: for his mercy endureth for ever.",
            "Psalm 107:1"
        ),
        Verse(
            "The Lord is good, a strong hold in the day of trouble; and he knoweth them that trust in him.",
            "Nahum 1:7"
        ),
        Verse(
            "Peace I leave with you, my peace I give unto you: not as the world giveth, give I unto you. Let not your heart be troubled, neither let it be afraid.",
            "John 14:27"
        ),
        Verse(
            "These things I have spoken unto you, that in me ye might have peace. In the world ye shall have tribulation: but be of good cheer; I have overcome the world.",
            "John 16:33"
        ),
        Verse(
            "Love is patient, love is kind. It does not envy, it does not boast, it is not proud.",
            "1 Corinthians 13:4"
        ),
        Verse(
            "And now abideth faith, hope, charity, these three; but the greatest of these is charity.",
            "1 Corinthians 13:13"
        ),
        Verse(
            "Rejoice in the Lord always: and again I say, Rejoice.",
            "Philippians 4:4"
        ),
        Verse(
            "Be careful for nothing; but in every thing by prayer and supplication with thanksgiving let your requests be made known unto God.",
            "Philippians 4:6"
        ),
        Verse(
            "And the peace of God, which passeth all understanding, shall keep your hearts and minds through Christ Jesus.",
            "Philippians 4:7"
        ),
        Verse(
            "I am the vine, ye are the branches: He that abideth in me, and I in him, the same bringeth forth much fruit: for without me ye can do nothing.",
            "John 15:5"
        ),
        Verse(
            "Greater love hath no man than this, that a man lay down his life for his friends.",
            "John 15:13"
        ),
        Verse(
            "Ask, and it shall be given you; seek, and ye shall find; knock, and it shall be opened unto you.",
            "Matthew 7:7"
        ),
        Verse(
            "But seek ye first the kingdom of God, and his righteousness; and all these things shall be added unto you.",
            "Matthew 6:33"
        ),
        Verse(
            "Take therefore no thought for the morrow: for the morrow shall take thought for the things of itself. Sufficient unto the day is the evil thereof.",
            "Matthew 6:34"
        ),
        Verse(
            "Blessed are the pure in heart: for they shall see God.",
            "Matthew 5:8"
        ),
        Verse(
            "Ye are the light of the world. A city that is set on an hill cannot be hid.",
            "Matthew 5:14"
        ),
        Verse(
            "Let your light so shine before men, that they may see your good works, and glorify your Father which is in heaven.",
            "Matthew 5:16"
        ),
        Verse(
            "Heaven and earth shall pass away, but my words shall not pass away.",
            "Matthew 24:35"
        ),
        Verse(
            "For where your treasure is, there will your heart be also.",
            "Matthew 6:21"
        ),
        Verse(
            "The name of the Lord is a strong tower: the righteous runneth into it, and is safe.",
            "Proverbs 18:10"
        ),
        Verse(
            "A soft answer turneth away wrath: but grievous words stir up anger.",
            "Proverbs 15:1"
        ),
        Verse(
            "Commit thy works unto the Lord, and thy thoughts shall be established.",
            "Proverbs 16:3"
        ),
        Verse(
            "The fear of the Lord is the beginning of wisdom: and the knowledge of the holy is understanding.",
            "Proverbs 9:10"
        ),
        Verse(
            "Iron sharpeneth iron; so a man sharpeneth the countenance of his friend.",
            "Proverbs 27:17"
        ),
        Verse(
            "He that is slow to anger is better than the mighty; and he that ruleth his spirit than he that taketh a city.",
            "Proverbs 16:32"
        ),
        Verse(
            "In all thy ways acknowledge him, and he shall direct thy paths.",
            "Proverbs 3:6"
        ),
        Verse(
            "The Lord is my strength and my shield; my heart trusted in him, and I am helped.",
            "Psalm 28:7"
        ),
        Verse(
            "God is our refuge and strength, a very present help in trouble.",
            "Psalm 46:1"
        ),
        Verse(
            "Bless the Lord, O my soul: and all that is within me, bless his holy name.",
            "Psalm 103:1"
        ),
        Verse(
            "He healeth the broken in heart, and bindeth up their wounds.",
            "Psalm 147:3"
        ),
        Verse(
            "O Lord, thou hast searched me, and known me.",
            "Psalm 139:1"
        ),
        Verse(
            "I will lift up mine eyes unto the hills, from whence cometh my help. My help cometh from the Lord, which made heaven and earth.",
            "Psalm 121:1-2"
        ),
        Verse(
            "The Lord shall preserve thee from all evil: he shall preserve thy soul.",
            "Psalm 121:7"
        ),
        Verse(
            "Wait on the Lord: be of good courage, and he shall strengthen thine heart: wait, I say, on the Lord.",
            "Psalm 27:14"
        ),
        Verse(
            "The Lord is gracious, and full of compassion; slow to anger, and of great mercy.",
            "Psalm 145:8"
        ),
        Verse(
            "Great is our Lord, and of great power: his understanding is infinite.",
            "Psalm 147:5"
        ),
        Verse(
            "Call unto me, and I will answer thee, and shew thee great and mighty things, which thou knowest not.",
            "Jeremiah 33:3"
        ),
        Verse(
            "It is of the Lord's mercies that we are not consumed, because his compassions fail not. They are new every morning: great is thy faithfulness.",
            "Lamentations 3:22-23"
        ),
        Verse(
            "But God commendeth his love toward us, in that, while we were yet sinners, Christ died for us.",
            "Romans 5:8"
        ),
        Verse(
            "For the wages of sin is death; but the gift of God is eternal life through Jesus Christ our Lord.",
            "Romans 6:23"
        ),
        Verse(
            "There is therefore now no condemnation to them which are in Christ Jesus.",
            "Romans 8:1"
        ),
        Verse(
            "If God be for us, who can be against us?",
            "Romans 8:31"
        ),
        Verse(
            "Nay, in all these things we are more than conquerors through him that loved us.",
            "Romans 8:37"
        ),
        Verse(
            "And be not conformed to this world: but be ye transformed by the renewing of your mind.",
            "Romans 12:2"
        ),
        Verse(
            "Let love be without dissimulation. Abhor that which is evil; cleave to that which is good.",
            "Romans 12:9"
        ),
        Verse(
            "Be not overcome of evil, but overcome evil with good.",
            "Romans 12:21"
        ),
        Verse(
            "Now the God of hope fill you with all joy and peace in believing, that ye may abound in hope, through the power of the Holy Ghost.",
            "Romans 15:13"
        ),
        Verse(
            "Know ye not that ye are the temple of God, and that the Spirit of God dwelleth in you?",
            "1 Corinthians 3:16"
        ),
        Verse(
            "Watch ye, stand fast in the faith, quit you like men, be strong.",
            "1 Corinthians 16:13"
        ),
        Verse(
            "Therefore if any man be in Christ, he is a new creature: old things are passed away; behold, all things are become new.",
            "2 Corinthians 5:17"
        ),
        Verse(
            "My grace is sufficient for thee: for my strength is made perfect in weakness.",
            "2 Corinthians 12:9"
        ),
        Verse(
            "But the fruit of the Spirit is love, joy, peace, longsuffering, gentleness, goodness, faith, Meekness, temperance: against such there is no law.",
            "Galatians 5:22-23"
        ),
        Verse(
            "And let us not be weary in well doing: for in due season we shall reap, if we faint not.",
            "Galatians 6:9"
        ),
        Verse(
            "For by grace are ye saved through faith; and that not of yourselves: it is the gift of God.",
            "Ephesians 2:8"
        ),
        Verse(
            "Be ye kind one to another, tenderhearted, forgiving one another, even as God for Christ's sake hath forgiven you.",
            "Ephesians 4:32"
        ),
        Verse(
            "Finally, my brethren, be strong in the Lord, and in the power of his might.",
            "Ephesians 6:10"
        ),
        Verse(
            "I can do all things through Christ which strengtheneth me.",
            "Philippians 4:13"
        ),
        Verse(
            "And my God shall supply all your need according to his riches in glory by Christ Jesus.",
            "Philippians 4:19"
        ),
        Verse(
            "Let the word of Christ dwell in you richly in all wisdom.",
            "Colossians 3:16"
        ),
        Verse(
            "And whatsoever ye do, do it heartily, as to the Lord, and not unto men.",
            "Colossians 3:23"
        ),
        Verse(
            "Rejoice evermore. Pray without ceasing. In every thing give thanks.",
            "1 Thessalonians 5:16-18"
        ),
        Verse(
            "For God hath not given us the spirit of fear; but of power, and of love, and of a sound mind.",
            "2 Timothy 1:7"
        ),
        Verse(
            "All scripture is given by inspiration of God, and is profitable for doctrine, for reproof, for correction, for instruction in righteousness.",
            "2 Timothy 3:16"
        ),
        Verse(
            "Looking unto Jesus the author and finisher of our faith.",
            "Hebrews 12:2"
        ),
        Verse(
            "Jesus Christ the same yesterday, and to day, and for ever.",
            "Hebrews 13:8"
        ),
        Verse(
            "If any of you lack wisdom, let him ask of God, that giveth to all men liberally, and upbraideth not; and it shall be given him.",
            "James 1:5"
        ),
        Verse(
            "Draw nigh to God, and he will draw nigh to you.",
            "James 4:8"
        ),
        Verse(
            "Humble yourselves therefore under the mighty hand of God, that he may exalt you in due time.",
            "1 Peter 5:6"
        ),
        Verse(
            "Casting all your care upon him; for he careth for you.",
            "1 Peter 5:7"
        ),
        Verse(
            "If we confess our sins, he is faithful and just to forgive us our sins, and to cleanse us from all unrighteousness.",
            "1 John 1:9"
        ),
        Verse(
            "Beloved, let us love one another: for love is of God; and every one that loveth is born of God, and knoweth God.",
            "1 John 4:7"
        ),
        Verse(
            "There is no fear in love; but perfect love casteth out fear.",
            "1 John 4:18"
        ),
        Verse(
            "Behold, I stand at the door, and knock: if any man hear my voice, and open the door, I will come in to him, and will sup with him, and he with me.",
            "Revelation 3:20"
        ),
        Verse(
            "And God shall wipe away all tears from their eyes; and there shall be no more death, neither sorrow, nor crying, neither shall there be any more pain: for the former things are passed away.",
            "Revelation 21:4"
        ),
        Verse(
            "The Lord is my portion, saith my soul; therefore will I hope in him.",
            "Lamentations 3:24"
        ),
        Verse(
            "He hath shewed thee, O man, what is good; and what doth the Lord require of thee, but to do justly, and to love mercy, and to walk humbly with thy God?",
            "Micah 6:8"
        ),
        Verse(
            "Not by might, nor by power, but by my spirit, saith the Lord of hosts.",
            "Zechariah 4:6"
        ),
        Verse(
            "The Lord thy God in the midst of thee is mighty; he will save, he will rejoice over thee with joy; he will rest in his love, he will joy over thee with singing.",
            "Zephaniah 3:17"
        )
    )

    fun getTodaysVerse(): Verse {
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        val index = (dayOfYear - 1) % verses.size
        return verses[index]
    }

    fun getVerseForDay(dayOfYear: Int): Verse {
        val index = (dayOfYear - 1).coerceAtLeast(0) % verses.size
        return verses[index]
    }

    fun getAllVerses(): List<Verse> = verses
}
